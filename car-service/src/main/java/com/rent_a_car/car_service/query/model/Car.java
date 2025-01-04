package com.rent_a_car.car_service.query.model;


import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "cars")
public class Car {

    @Id
    private String id;

    private String name;
    private int seatCount;
    private int luggageCapacity;
    private boolean passengerAirbag;
    private boolean abs;
    private String fuelType;
    private String transmissionType;
    private String brandName;
    private int minimumAge;
    private int minimumLicenseAge;
    private int requiredCreditCards;
    public Car() {
    }

    public Car(String id, String name, int seatCount, int luggageCapacity, boolean passengerAirbag, boolean abs, String fuelType, String transmissionType, String brandName, int minimumAge, int minimumLicenseAge, int requiredCreditCards) {
        this.id = id;
        this.name = name;
        this.seatCount = seatCount;
        this.luggageCapacity = luggageCapacity;
        this.passengerAirbag = passengerAirbag;
        this.abs = abs;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.brandName = brandName;
        this.minimumAge = minimumAge;
        this.minimumLicenseAge = minimumLicenseAge;
        this.requiredCreditCards = requiredCreditCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getMinimumLicenseAge() {
        return minimumLicenseAge;
    }

    public void setMinimumLicenseAge(int minimumLicenseAge) {
        this.minimumLicenseAge = minimumLicenseAge;
    }

    public int getRequiredCreditCards() {
        return requiredCreditCards;
    }

    public void setRequiredCreditCards(int requiredCreditCards) {
        this.requiredCreditCards = requiredCreditCards;
    }
}
