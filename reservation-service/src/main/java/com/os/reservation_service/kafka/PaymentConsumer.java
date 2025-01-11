package com.os.reservation_service.kafka;

import com.os.event.PaymentFailedEvent;
import com.os.reservation_service.service.ReservationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    private final ReservationService reservationService;

    public PaymentConsumer(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @KafkaListener(topics = "${spring.kafka.template.payment-failed-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(PaymentFailedEvent event)
    {
        reservationService.deleteReservation(event.getReservationId());
        System.out.println("Reservation Deleted: " + event);

    }
}
