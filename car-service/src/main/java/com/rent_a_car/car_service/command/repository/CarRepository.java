package com.rent_a_car.car_service.command.repository;

import com.rent_a_car.car_service.command.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
