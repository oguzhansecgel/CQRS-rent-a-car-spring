package com.rent_a_car.car_service.command.kafka;

import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CarEventProducer {

    private final KafkaTemplate<String, CarCreatedEvent> kafkaTemplate;
    private final Logger log = Logger.getLogger(CarEventProducer.class.getName());
    @Value("${spring.kafka.template.car-created-topic}")
    private String defaultTopic;

    public CarEventProducer(KafkaTemplate<String, CarCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(CarCreatedEvent message) {
        System.out.println("Event Created Sout: ");
        log.info("Event Created Log: ");
        kafkaTemplate.send(defaultTopic, message);

    }
}
