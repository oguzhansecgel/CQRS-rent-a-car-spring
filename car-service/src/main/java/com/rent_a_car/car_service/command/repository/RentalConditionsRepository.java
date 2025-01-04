package com.rent_a_car.car_service.command.repository;


import com.rent_a_car.car_service.command.model.RentalConditions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalConditionsRepository extends JpaRepository<RentalConditions, Integer> {
}
