package com.os.payment_service.kafka;

import com.os.event.PaymentFailedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationProducer {
    private static final Logger log = LoggerFactory.getLogger(ReservationProducer.class);
    private final KafkaTemplate<String, PaymentFailedEvent> kafkaTemplate;

    public ReservationProducer(KafkaTemplate<String, PaymentFailedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${spring.kafka.template.payment-failed-topic}")
    private String defaultTopic;

    public void sendMessage(PaymentFailedEvent message) {
        System.out.println("Event Failed Sout: ");
        log.info("Event Failed Log: ");
        kafkaTemplate.send(defaultTopic, message);

    }
}
