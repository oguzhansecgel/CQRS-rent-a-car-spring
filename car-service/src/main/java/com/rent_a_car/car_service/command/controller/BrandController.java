package com.rent_a_car.car_service.command.controller;

import com.rent_a_car.car_service.command.commands.brand.CreateBrandCommand;
import com.rent_a_car.car_service.command.result.ApiResponse;
import com.rent_a_car.car_service.command.service.BrandCommandHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {

    private final BrandCommandHandler brandCommandHandler;

    public BrandController(BrandCommandHandler brandCommandHandler) {
        this.brandCommandHandler = brandCommandHandler;
    }

    @PostMapping("/create/brand")
    public ApiResponse<Void> createBrand(@RequestBody CreateBrandCommand command)
    {
        brandCommandHandler.createBrandCommand(command);
        return new ApiResponse<>(true,"Brand created successfully",null);

    }
}
