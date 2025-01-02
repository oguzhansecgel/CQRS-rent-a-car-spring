package com.rent_a_car.car_service.command.service;

import com.rent_a_car.car_service.command.commands.car.CreateCarCommand;
import com.rent_a_car.car_service.command.commands.car.UpdateCarCommand;
import com.rent_a_car.car_service.command.dto.car.CreateCarResponse;
import com.rent_a_car.car_service.command.dto.car.UpdateCarResponse;
import com.rent_a_car.car_service.command.kafka.CarEventProducer;
import com.rent_a_car.car_service.command.model.Car;
import com.rent_a_car.car_service.command.repository.BrandRepository;
import com.rent_a_car.car_service.command.repository.CarRepository;
import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.event.car.CarDeletedEvent;
import com.rent_a_car.car_service.event.car.CarUpdatedEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public CreateCarResponse createCarCommand(CreateCarCommand createCarCommand)
    {
        Car car = new Car();
        car.setName(createCarCommand.getName());
        car.setBrand(brandRepository.findById(createCarCommand.getBrandId()).orElseThrow());
        Car savedCar =  carRepository.save(car);
        CarCreatedEvent carCreatedEvent = new CarCreatedEvent(car.getId(),car.getName(), car.getBrand().getName());
        carEventProducer.sendMessage(carCreatedEvent);
        return new CreateCarResponse(savedCar.getId(),savedCar.getName(),savedCar.getBrand().getName());

    }
    public UpdateCarResponse updateCarCommand(UpdateCarCommand updateCarCommand, int id)
    {
        Optional<Car> existingCar = carRepository.findById(id);
        Car car = existingCar.get();
        car.setName(updateCarCommand.getName());
        car.setBrand(brandRepository.findById(updateCarCommand.getBrandId()).orElseThrow());
        Car savedCar = carRepository.save(car);
        CarUpdatedEvent event = new CarUpdatedEvent(savedCar.getId(),savedCar.getName(),savedCar.getBrand().getName());
        carEventProducer.sendUpdateMessage(event);
        return new UpdateCarResponse(savedCar.getId(),savedCar.getName(),savedCar.getBrand().getName());
    }
    public void deletedCarCommand(int id)
    {
        Optional<Car> existingCar = carRepository.findById(id);
        Car car = existingCar.get();
        CarDeletedEvent event = new CarDeletedEvent(car.getId());
        carEventProducer.sendDeleteMessage(event);
        carRepository.delete(car);
    }
}
