package com.rent_a_car.car_service.command.controller;

import com.rent_a_car.car_service.command.commands.car.CreateCarCommand;
import com.rent_a_car.car_service.command.commands.car.UpdateCarCommand;
import com.rent_a_car.car_service.command.dto.car.CreateCarResponse;
import com.rent_a_car.car_service.command.dto.car.UpdateCarResponse;
import com.rent_a_car.car_service.shared.exception.ApiResult;
import com.rent_a_car.car_service.command.service.CarCommandHandler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    private final CarCommandHandler carCommandHandler;

    public CarController(CarCommandHandler carCommandHandler) {
        this.carCommandHandler = carCommandHandler;
    }

    @DeleteMapping("/deleted/car/{id}")
    public ApiResult<Void> deleteCar(@PathVariable int id)
    {
        carCommandHandler.deletedCarCommand(id);
        return new ApiResult<>(true,"Car deleted successfully",null);

    }
    @PostMapping("/create/car")
    public ApiResult<CreateCarResponse> createCar(@Valid @RequestBody CreateCarCommand command)
    {
        CreateCarResponse response =  carCommandHandler.createCarCommand(command);
        return new ApiResult<>(true,"Car created successfully",response);
    }
    @PutMapping("/update/car/{id}")
    public ApiResult<UpdateCarResponse> updateCar(@Valid @RequestBody UpdateCarCommand command, @PathVariable int id)
    {
        UpdateCarResponse response = carCommandHandler.updateCarCommand(command, id);
        return new ApiResult<>(true,"Car updated successfully",response);
    }
}
