package com.rent_a_car.car_service.command.commands.car;


import jakarta.validation.constraints.NotEmpty;

public class UpdateCarCommand {

    @NotEmpty(message = "{car.name.validation.constraints.NotNull.message}")
    private String name;
    private int brandId;

    public UpdateCarCommand() {
    }

    public UpdateCarCommand( String name, int brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
