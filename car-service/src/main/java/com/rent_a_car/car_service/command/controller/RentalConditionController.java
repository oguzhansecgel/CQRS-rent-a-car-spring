package com.rent_a_car.car_service.command.controller;

import com.rent_a_car.car_service.command.commands.rentalConditions.CreateRentalConditionCommand;
import com.rent_a_car.car_service.command.dto.rentalConditions.CreateRentalConditionResponse;
import com.rent_a_car.car_service.command.service.RentalConditionsHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rentalCondition")
public class RentalConditionController {

    private final RentalConditionsHandler rentalConditionsHandler;

    public RentalConditionController(RentalConditionsHandler rentalConditionsHandler) {
        this.rentalConditionsHandler = rentalConditionsHandler;
    }

    @PostMapping("/create/rental/condition")
    public CreateRentalConditionResponse createRentalCondition(@RequestBody CreateRentalConditionCommand command)
    {
        return rentalConditionsHandler.createRentalCondition(command);
    }
}
