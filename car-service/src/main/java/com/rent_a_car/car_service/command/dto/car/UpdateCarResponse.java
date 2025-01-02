package com.rent_a_car.car_service.command.dto.car;

public class UpdateCarResponse {
    private int id;

    private String name;

    private String brandName;

    public UpdateCarResponse() {
    }

    public UpdateCarResponse(int id, String name, String brandName) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
