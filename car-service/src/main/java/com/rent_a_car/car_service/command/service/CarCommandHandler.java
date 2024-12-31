package com.rent_a_car.car_service.command.service;

import com.rent_a_car.car_service.command.commands.car.CreateCarCommand;
import com.rent_a_car.car_service.command.kafka.CarEventProducer;
import com.rent_a_car.car_service.command.model.Car;
import com.rent_a_car.car_service.command.repository.BrandRepository;
import com.rent_a_car.car_service.command.repository.CarRepository;
import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import org.springframework.stereotype.Service;

@Service
public class CarCommandHandler {
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final CarEventProducer carEventProducer;

    public CarCommandHandler(CarRepository carRepository, BrandRepository brandRepository, CarEventProducer carEventProducer) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.carEventProducer = carEventProducer;
    }

    public void createCarCommand(CreateCarCommand createCarCommand)
    {
        Car car = new Car();
        car.setName(createCarCommand.getName());
        car.setBrand(brandRepository.findById(createCarCommand.getBrandId()).orElseThrow());
        carRepository.save(car);
        CarCreatedEvent carCreatedEvent = new CarCreatedEvent(car.getName(), car.getBrand().getName());
        carEventProducer.sendMessage(carCreatedEvent);
    }
}
