package com.rent_a_car.car_service.command.dto.car;

public class UpdateCarResponse {
    private int id;
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

    public UpdateCarResponse() {
    }

    public UpdateCarResponse(int id, String name, int seatCount, int luggageCapacity, boolean passengerAirbag, boolean abs, String fuelType, String transmissionType, int brandId, int rentalConditionsId, Double dayPrice, Double weekPrice, Double monthPrice) {
        this.id = id;
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
