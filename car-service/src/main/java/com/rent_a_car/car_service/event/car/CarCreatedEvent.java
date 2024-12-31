package com.rent_a_car.car_service.event.car;

public class CarCreatedEvent {
    private String name;
    private String brandName;

    public CarCreatedEvent() {
    }

    public CarCreatedEvent(String name, String brandName) {
        this.name = name;
        this.brandName = brandName;
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
