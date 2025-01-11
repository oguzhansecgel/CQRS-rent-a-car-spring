package com.os.payment_service.service.impl;

import com.os.event.PaymentFailedEvent;
import com.os.payment_service.dto.request.CreatePaymentRequest;
import com.os.payment_service.kafka.ReservationProducer;
import com.os.payment_service.model.Payment;
import com.os.payment_service.repository.PaymentRepository;
import com.os.payment_service.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ReservationProducer reservationProducer;


    public PaymentServiceImpl(PaymentRepository paymentRepository, ReservationProducer reservationProducer) {
        this.paymentRepository = paymentRepository;
        this.reservationProducer = reservationProducer;
    }

    @Override
    public void payment(CreatePaymentRequest request) {

        try {
            Payment payment = new Payment();
            payment.setCardNumber(request.getCardNumber());
            paymentRepository.save(payment);
        }
        catch (Exception e)
        {
            PaymentFailedEvent paymentFailedEvent = new PaymentFailedEvent(request.getReservationId());
            reservationProducer.sendMessage(paymentFailedEvent);
        }

    }
}
