package com.rent_a_car.car_service.query.kafka;

import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.query.service.ElasticSearchCarService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarEventConsumer {

    private final ElasticSearchCarService service;

    public CarEventConsumer(ElasticSearchCarService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${spring.kafka.template.car-created-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(CarCreatedEvent event)
    {
        System.out.println("OrderCreatedEvent: " + event);
        service.createCarElasticSearchDB(event);
    }
}
