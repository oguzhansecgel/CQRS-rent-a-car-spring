package com.os.reservation_service.model;

public class CarRentalConditionsDto {
    private int id;

    private int minimumAge;
    private int minimumLicenseAge;
    private int requiredCreditCards;

    public CarRentalConditionsDto(int id, int minimumAge, int minimumLicenseAge, int requiredCreditCards) {
        this.id = id;
        this.minimumAge = minimumAge;
        this.minimumLicenseAge = minimumLicenseAge;
        this.requiredCreditCards = requiredCreditCards;
    }

    public CarRentalConditionsDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
