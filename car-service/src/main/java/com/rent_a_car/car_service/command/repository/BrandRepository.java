package com.rent_a_car.car_service.command.repository;

import com.rent_a_car.car_service.command.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
