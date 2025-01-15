package com.rent_a_car.car_service.command.service;

import com.rent_a_car.car_service.command.commands.car.CreateCarCommand;
import com.rent_a_car.car_service.command.commands.car.UpdateCarCommand;
import com.rent_a_car.car_service.command.dto.car.CreateCarResponse;
import com.rent_a_car.car_service.command.dto.car.UpdateCarResponse;
import com.rent_a_car.car_service.command.kafka.CarEventProducer;
import com.rent_a_car.car_service.command.model.Car;
import com.rent_a_car.car_service.command.repository.BrandRepository;
import com.rent_a_car.car_service.command.repository.CarRepository;
import com.rent_a_car.car_service.command.repository.RentalConditionsRepository;
import com.rent_a_car.car_service.shared.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.shared.event.car.CarDeletedEvent;
import com.rent_a_car.car_service.shared.event.car.CarUpdatedEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarCommandHandler {
    private final CarRepository carRepository;
    private final BrandRepository brandRepository;
    private final RentalConditionsRepository conditionsRepository;
    private final CarEventProducer carEventProducer;

    public CarCommandHandler(CarRepository carRepository, BrandRepository brandRepository, RentalConditionsRepository conditionsRepository, CarEventProducer carEventProducer) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.conditionsRepository = conditionsRepository;
        this.carEventProducer = carEventProducer;
    }

    public CreateCarResponse createCarCommand(CreateCarCommand createCarCommand)
    {
        Car car = new Car();
        car.setName(createCarCommand.getName());
        car.setSeatCount(createCarCommand.getSeatCount());
        car.setLuggageCapacity(createCarCommand.getLuggageCapacity());
        car.setPassengerAirbag(createCarCommand.isPassengerAirbag());
        car.setAbs(createCarCommand.isAbs());
        car.setFuelType(createCarCommand.getFuelType());
        car.setTransmissionType(createCarCommand.getTransmissionType());
        car.setDayPrice(createCarCommand.getDayPrice());
        car.setBrand(brandRepository.findById(createCarCommand.getBrandId()).orElseThrow());

        car.setRentalConditions(conditionsRepository.findById(createCarCommand.getRentalConditionsId())
                .orElseThrow(() -> new IllegalArgumentException("Rental conditions not found")));

        Car savedCar =  carRepository.save(car);
        CarCreatedEvent carCreatedEvent = new CarCreatedEvent(
                car.getId(),
                car.getName(),
                car.getSeatCount(),
                car.getLuggageCapacity(),
                car.isPassengerAirbag(),
                car.isAbs(),
                car.getFuelType(),
                car.getTransmissionType(),
                car.getBrand().getName(),
                car.getRentalConditions().getMinimumAge(),
                car.getRentalConditions().getMinimumLicenseAge(),
                car.getRentalConditions().getRequiredCreditCards(),
                car.getDayPrice()
        );
        carEventProducer.sendMessage(carCreatedEvent);
        return new CreateCarResponse(
                savedCar.getId(),
                savedCar.getName(),
                savedCar.getSeatCount(),
                savedCar.getLuggageCapacity(),
                savedCar.isPassengerAirbag(),
                savedCar.isAbs(),
                savedCar.getFuelType(),
                savedCar.getTransmissionType(),
                savedCar.getBrand().getId(),
                savedCar.getRentalConditions().getId(),
                savedCar.getDayPrice()
        );

    }
    public UpdateCarResponse updateCarCommand(UpdateCarCommand updateCarCommand, int id)
    {
        Optional<Car> existingCar = carRepository.findById(id);
        Car car = existingCar.get();
        car.setName(updateCarCommand.getName());
        car.setSeatCount(updateCarCommand.getSeatCount());
        car.setLuggageCapacity(updateCarCommand.getLuggageCapacity());
        car.setPassengerAirbag(updateCarCommand.isPassengerAirbag());
        car.setAbs(updateCarCommand.isAbs());
        car.setFuelType(updateCarCommand.getFuelType());
        car.setTransmissionType(updateCarCommand.getTransmissionType());
        car.setDayPrice(updateCarCommand.getDayPrice());
        car.setBrand(brandRepository.findById(updateCarCommand.getBrandId()).orElseThrow());
        car.setDayPrice(updateCarCommand.getDayPrice());
        car.setRentalConditions(conditionsRepository.findById(updateCarCommand.getRentalConditionsId())
                .orElseThrow(() -> new IllegalArgumentException("Rental conditions not found")));

        Car savedCar =  carRepository.save(car);
        CarUpdatedEvent event = new CarUpdatedEvent(
                car.getId(),
                car.getName(),
                car.getSeatCount(),
                car.getLuggageCapacity(),
                car.isPassengerAirbag(),
                car.isAbs(),
                car.getFuelType(),
                car.getTransmissionType(),
                car.getBrand().getName(),
                car.getRentalConditions().getMinimumAge(),
                car.getRentalConditions().getMinimumLicenseAge(),
                car.getRentalConditions().getRequiredCreditCards(),
                car.getDayPrice()
        );
        carEventProducer.sendUpdateMessage(event);
        return new UpdateCarResponse(
                savedCar.getId(),
                savedCar.getName(),
                savedCar.getSeatCount(),
                savedCar.getLuggageCapacity(),
                savedCar.isPassengerAirbag(),
                savedCar.isAbs(),
                savedCar.getFuelType(),
                savedCar.getTransmissionType(),
                savedCar.getBrand().getId(),
                savedCar.getRentalConditions().getId(),
                savedCar.getDayPrice()
        );
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
