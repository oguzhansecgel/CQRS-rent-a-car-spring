package com.rent_a_car.car_service.command.commands.car;

public class CreateCarCommand {
    private String name;
    private int brandId;

    public CreateCarCommand() {
    }

    public CreateCarCommand(String name, int brandId) {
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
