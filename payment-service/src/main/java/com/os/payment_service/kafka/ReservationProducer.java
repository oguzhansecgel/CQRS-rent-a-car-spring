package com.os.payment_service.kafka;

import com.os.event.PaymentCreatedEvent;
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
    private final KafkaTemplate<String, PaymentCreatedEvent> kafkaSuccessfly;

    public ReservationProducer(KafkaTemplate<String, PaymentFailedEvent> kafkaTemplate, KafkaTemplate<String, PaymentCreatedEvent> kafkaSuccessfly) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaSuccessfly = kafkaSuccessfly;
    }

    @Value("${spring.kafka.template.payment-failed-topic}")
    private String defaultTopic;

    @Value("${spring.kafka.template.payment-success-topic}")
    private String paymentCreatedTopic;

    public void sendMessage(PaymentFailedEvent message) {
        System.out.println("Event Failed Sout: ");
        log.info("Event Failed Log: ");
        kafkaTemplate.send(defaultTopic, message);

    }

    public void sendSMessage(PaymentCreatedEvent event)
    {
        System.out.println("Event Created Sout: ");
        System.out.println("Class get name: "+ event.getClass().getName());
        log.info("Event Created Log: ");
        kafkaSuccessfly.send(paymentCreatedTopic,event);
    }
}
