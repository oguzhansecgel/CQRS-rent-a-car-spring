package com.os.reservation_service.kafka;

import com.os.event.ReservationCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {

    private static final Logger log = LoggerFactory.getLogger(PaymentProducer.class);
    private final KafkaTemplate<String, ReservationCreatedEvent> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, ReservationCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${spring.kafka.template.reservation-created-topic}")
    private String defaultTopic;

    public void sendMessage(ReservationCreatedEvent message) {
        System.out.println("Reservation Event Created Sout: ");
        log.info("Reservation Event Created Log: ");
        kafkaTemplate.send(defaultTopic, message);

    }
}