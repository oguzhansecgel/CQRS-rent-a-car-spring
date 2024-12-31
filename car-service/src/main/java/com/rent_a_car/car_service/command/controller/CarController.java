package com.rent_a_car.car_service.command.controller;

import com.rent_a_car.car_service.command.commands.car.CreateCarCommand;
import com.rent_a_car.car_service.command.service.CarCommandHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    private final CarCommandHandler carCommandHandler;

    public CarController(CarCommandHandler carCommandHandler) {
        this.carCommandHandler = carCommandHandler;
    }

    @PostMapping("/create/car")
    public void createCar(@RequestBody CreateCarCommand command)
    {
        carCommandHandler.createCarCommand(command);
    }
}
