package com.os.payment_service.kafka;

import com.os.event.ReservationCreatedEvent;
import com.os.payment_service.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReservationConsumer {

    private final PaymentService paymentService;

    public ReservationConsumer(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "${spring.kafka.template.reservation-created-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ReservationCreatedEvent event)
    {
        paymentService.handleReservationCreated(event);
        System.out.println("Reservasion Created Event: " + event);

    }
}