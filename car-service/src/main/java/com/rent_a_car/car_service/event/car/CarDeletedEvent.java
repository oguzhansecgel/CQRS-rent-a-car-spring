package com.rent_a_car.car_service.event.car;

public class CarDeletedEvent {
    private int id;

    public CarDeletedEvent() {
    }

    public CarDeletedEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
