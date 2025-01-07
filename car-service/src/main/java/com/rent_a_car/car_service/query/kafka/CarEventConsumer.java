package com.rent_a_car.car_service.query.kafka;

import com.rent_a_car.car_service.shared.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.shared.event.car.CarDeletedEvent;
import com.rent_a_car.car_service.shared.event.car.CarUpdatedEvent;
import com.rent_a_car.car_service.query.service.ElasticSearchCarService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CarEventConsumer {

    private final ElasticSearchCarService service;

    public CarEventConsumer(ElasticSearchCarService service) {
        this.service = service;
    }

    @KafkaListener(
            topics = "${spring.kafka.template.car-created-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(CarCreatedEvent event)
    {
        System.out.println("consumer created event : " + event);
        service.createCarElasticSearchDB(event);
    }
    @KafkaListener(
            topics = "${spring.kafka.template.car-updated-topic}",
            groupId = "${spring.kafka.consumer.group-update-id}",
            containerFactory = "kafkaListenerUpdateContainerFactory"
    )
    public void consumeUpdate(CarUpdatedEvent event)
    {
        System.out.println("Car Update Event: " + event);
        service.updateCarElasticSearchDB(event);
    }

    @KafkaListener(
            topics = "${spring.kafka.template.car-deleted-topic}",
            groupId = "${spring.kafka.consumer.group-delete-id}",
            containerFactory = "kafkaListenerDeleteContainerFactory"
    )
    public void consumeDelete(CarDeletedEvent event)
    {
        System.out.println("Car Delete Event: " + event);
        service.deleteCarElasticSearchDB(String.valueOf(event.getId()));
    }


}
