package com.rent_a_car.car_service.command.model;


import jakarta.persistence.*;

@Table(name = "cars")
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private int seatCount;
    private int luggageCapacity;
    private boolean passengerAirbag;
    private boolean abs;
    private String fuelType;
    private String transmissionType;
    private Double dayPrice;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "rental_conditions_id")
    private RentalConditions rentalConditions;

    public Car() {
    }

    public Car(int id, String name, int seatCount, int luggageCapacity, boolean passengerAirbag, boolean abs, String fuelType, String transmissionType, Double dayPrice, Brand brand, RentalConditions rentalConditions) {
        this.id = id;
        this.name = name;
        this.seatCount = seatCount;
        this.luggageCapacity = luggageCapacity;
        this.passengerAirbag = passengerAirbag;
        this.abs = abs;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.dayPrice = dayPrice;
        this.brand = brand;
        this.rentalConditions = rentalConditions;
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

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getLuggageCapacity() {
        return luggageCapacity;
    }

    public void setLuggageCapacity(int luggageCapacity) {
        this.luggageCapacity = luggageCapacity;
    }

    public boolean isPassengerAirbag() {
        return passengerAirbag;
    }

    public void setPassengerAirbag(boolean passengerAirbag) {
        this.passengerAirbag = passengerAirbag;
    }

    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(Double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public RentalConditions getRentalConditions() {
        return rentalConditions;
    }

    public void setRentalConditions(RentalConditions rentalConditions) {
        this.rentalConditions = rentalConditions;
    }
}
