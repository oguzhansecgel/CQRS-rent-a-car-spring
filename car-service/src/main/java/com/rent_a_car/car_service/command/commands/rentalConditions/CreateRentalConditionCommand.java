package com.rent_a_car.car_service.command.commands.rentalConditions;

public class CreateRentalConditionCommand {

    private int minimumAge;
    private int minimumLicenseAge;
    private int requiredCreditCards;

    public CreateRentalConditionCommand() {
    }

    public CreateRentalConditionCommand(int minimumAge, int minimumLicenseAge, int requiredCreditCards) {
        this.minimumAge = minimumAge;
        this.minimumLicenseAge = minimumLicenseAge;
        this.requiredCreditCards = requiredCreditCards;
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
