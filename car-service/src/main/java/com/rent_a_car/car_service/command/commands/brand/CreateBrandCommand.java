package com.rent_a_car.car_service.command.commands.brand;

public class CreateBrandCommand {
    private String name;

    public CreateBrandCommand() {
    }

    public CreateBrandCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
