package com.rent_a_car.car_service.command.commands.car;

import jakarta.validation.constraints.NotEmpty;

public class CreateCarCommand {
    @NotEmpty(message = "{car.name.validation.constraints.NotNull.message}")
    private String name;
    private int seatCount;
    private int luggageCapacity;
    private boolean passengerAirbag;
    private boolean abs;
    private String fuelType;
    private String transmissionType;
    private int brandId;
    private int rentalConditionsId;
    private Double dayPrice;
    private Double weekPrice;
    private Double monthPrice;


    public CreateCarCommand() {
    }

    public CreateCarCommand(String name, int seatCount, int luggageCapacity, boolean passengerAirbag, boolean abs, String fuelType, String transmissionType, int brandId, int rentalConditionsId, Double dayPrice, Double weekPrice, Double monthPrice) {
        this.name = name;
        this.seatCount = seatCount;
        this.luggageCapacity = luggageCapacity;
        this.passengerAirbag = passengerAirbag;
        this.abs = abs;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.brandId = brandId;
        this.rentalConditionsId = rentalConditionsId;
        this.dayPrice = dayPrice;
        this.weekPrice = weekPrice;
        this.monthPrice = monthPrice;
    }

    public @NotEmpty(message = "{car.name.validation.constraints.NotNull.message}") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "{car.name.validation.constraints.NotNull.message}") String name) {
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

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getRentalConditionsId() {
        return rentalConditionsId;
    }

    public void setRentalConditionsId(int rentalConditionsId) {
        this.rentalConditionsId = rentalConditionsId;
    }

    public Double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(Double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public Double getWeekPrice() {
        return weekPrice;
    }

    public void setWeekPrice(Double weekPrice) {
        this.weekPrice = weekPrice;
    }

    public Double getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(Double monthPrice) {
        this.monthPrice = monthPrice;
    }
}
