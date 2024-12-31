package com.rent_a_car.car_service.command.service;

import com.rent_a_car.car_service.command.commands.brand.CreateBrandCommand;
import com.rent_a_car.car_service.command.model.Brand;
import com.rent_a_car.car_service.command.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandCommandHandler {

    private final BrandRepository brandRepository;

    public BrandCommandHandler(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void createBrandCommand(CreateBrandCommand command)
    {
        Brand brand = new Brand();
        brand.setName(command.getName());
        brandRepository.save(brand);
    }
}
