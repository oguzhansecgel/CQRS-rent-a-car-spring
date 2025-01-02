package com.rent_a_car.car_service.command.kafka;

import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.event.car.CarDeletedEvent;
import com.rent_a_car.car_service.event.car.CarUpdatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CarEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final Logger log = Logger.getLogger(CarEventProducer.class.getName());

    @Value("${spring.kafka.template.car-created-topic}")
    private String createdTopic;

    @Value("${spring.kafka.template.car-updated-topic}")
    private String updatedTopic;

    @Value("${spring.kafka.template.car-deleted-topic}")
    private String deletedopic;


    public CarEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(CarCreatedEvent message) {
        log.info("Car Event Created Log");
        kafkaTemplate.send(createdTopic, message);

    }
    public void sendUpdateMessage(CarUpdatedEvent message) {
        log.info("Car Event Update Log");
        kafkaTemplate.send(updatedTopic, message);

    }
    public void sendDeleteMessage(CarDeletedEvent message) {
        log.info("Car Event Delete Log");
        kafkaTemplate.send(deletedopic, message);

    }
}
