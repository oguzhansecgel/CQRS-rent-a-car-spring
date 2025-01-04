package com.rent_a_car.car_service.command.service;

import com.rent_a_car.car_service.command.commands.rentalConditions.CreateRentalConditionCommand;
import com.rent_a_car.car_service.command.dto.rentalConditions.CreateRentalConditionResponse;
import com.rent_a_car.car_service.command.model.RentalConditions;
import com.rent_a_car.car_service.command.repository.RentalConditionsRepository;
import org.springframework.stereotype.Service;

@Service
public class RentalConditionsHandler {


    private final RentalConditionsRepository repository;

    public RentalConditionsHandler(RentalConditionsRepository repository) {
        this.repository = repository;
    }

    public CreateRentalConditionResponse createRentalCondition(CreateRentalConditionCommand command)
    {
        RentalConditions rentalConditions = new RentalConditions();
        rentalConditions.setMinimumAge(command.getMinimumAge());
        rentalConditions.setMinimumLicenseAge(command.getMinimumLicenseAge());
        rentalConditions.setRequiredCreditCards(command.getRequiredCreditCards());

        RentalConditions savedRentalConditions = repository.save(rentalConditions);

        return new CreateRentalConditionResponse(
                savedRentalConditions.getId(),
                savedRentalConditions.getMinimumAge(),
                savedRentalConditions.getMinimumLicenseAge(),
                savedRentalConditions.getRequiredCreditCards()
        );
    }
}
