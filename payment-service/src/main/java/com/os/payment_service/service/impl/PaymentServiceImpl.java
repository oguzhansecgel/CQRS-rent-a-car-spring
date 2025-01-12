package com.os.payment_service.service.impl;

import com.os.event.PaymentCreatedEvent;
import com.os.event.PaymentFailedEvent;
import com.os.event.ReservationCreatedEvent;
import com.os.payment_service.dto.request.CreatePaymentRequest;
import com.os.payment_service.kafka.ReservationProducer;
import com.os.payment_service.model.Payment;
import com.os.payment_service.repository.PaymentRepository;
import com.os.payment_service.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ReservationProducer reservationProducer;


    public PaymentServiceImpl(PaymentRepository paymentRepository, ReservationProducer reservationProducer) {
        this.paymentRepository = paymentRepository;
        this.reservationProducer = reservationProducer;
    }
    public void handleReservationCreated(ReservationCreatedEvent event) {
        Payment payment = new Payment();
        payment.setReservationId(event.getReservationId());
        payment.setTotalAmount(event.getTotalPrice());
        paymentRepository.save(payment);
    }
    @Override
    @Transactional
    public void payment(CreatePaymentRequest request) {
        Payment payment = paymentRepository.findByReservationId(request.getReservationId());
        if (payment == null) {
            throw new RuntimeException("Payment not found for reservation: " + request.getReservationId());
        }

        try {
            payment.setCardNumber(request.getCardNumber());
            payment.setExpiryDate(request.getExpiryDate());
            payment.setCvv(request.getCvv());

            boolean paymentSuccess = processPayment(payment);

            if (paymentSuccess) {
                paymentRepository.save(payment);
                PaymentCreatedEvent event = new PaymentCreatedEvent();
                event.setId(payment.getReservationId());
                reservationProducer.sendSMessage(event);
            } else {

                PaymentFailedEvent failedEvent = new PaymentFailedEvent();
                failedEvent.setReservationId(payment.getReservationId());
                reservationProducer.sendMessage(failedEvent);
                paymentRepository.delete(payment);
            }

        } catch (Exception e) {

            PaymentFailedEvent errorEvent = new PaymentFailedEvent();
            errorEvent.setReservationId(payment.getReservationId());
            paymentRepository.delete(payment);
            throw new RuntimeException("Payment failed", e);
        }
    }

    private boolean processPayment(Payment payment) {
        return payment.getTotalAmount()<300 ? false : true;
    }
}
