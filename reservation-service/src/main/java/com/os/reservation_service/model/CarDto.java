package com.os.reservation_service.model;

public class CarDto {
    private int id;
    private String name;
    private int seatCount;
    private int luggageCapacity;
    private boolean passengerAirbag;
    private boolean abs;
    private String fuelType;
    private String transmissionType;
    private String brandName;
    private CarRentalConditionsDto conditions;
    private Double dayPrice;
    private Double weekPrice;
    private Double monthPrice;

    public CarDto() {
    }

    public CarDto(int id, String name, int seatCount, int luggageCapacity, boolean passengerAirbag, boolean abs, String fuelType, String transmissionType, String brandName, CarRentalConditionsDto conditions, Double dayPrice, Double weekPrice, Double monthPrice) {
        this.id = id;
        this.name = name;
        this.seatCount = seatCount;
        this.luggageCapacity = luggageCapacity;
        this.passengerAirbag = passengerAirbag;
        this.abs = abs;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.brandName = brandName;
        this.conditions = conditions;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public CarRentalConditionsDto getConditions() {
        return conditions;
    }

    public void setConditions(CarRentalConditionsDto conditions) {
        this.conditions = conditions;
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

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatCount=" + seatCount +
                ", luggageCapacity=" + luggageCapacity +
                ", passengerAirbag=" + passengerAirbag +
                ", abs=" + abs +
                ", fuelType='" + fuelType + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", brandName='" + brandName + '\'' +
                ", conditions=" + conditions +
                ", dayPrice=" + dayPrice +
                ", weekPrice=" + weekPrice +
                ", monthPrice=" + monthPrice +
                '}';
    }
}
