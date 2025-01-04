package com.rent_a_car.car_service.command.model;

import jakarta.persistence.*;
@Table(name = "rental_conditions")
@Entity
public class RentalConditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int minimumAge;         // Minimum yaş (örneğin: 21)
    private int minimumLicenseAge;  // Ehliyet yaşı (örneğin: 1 yıl)
    private int requiredCreditCards; // Gerekli kredi kartı sayısı (örneğin: 1)

    public RentalConditions() {}

    public RentalConditions(int minimumAge, int minimumLicenseAge, int requiredCreditCards) {
        this.minimumAge = minimumAge;
        this.minimumLicenseAge = minimumLicenseAge;
        this.requiredCreditCards = requiredCreditCards;
    }

    // Getter ve Setter metotları
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

    // toString metodu
    @Override
    public String toString() {
        return "RentalConditions{" +
                "minimumAge=" + minimumAge +
                ", minimumLicenseAge=" + minimumLicenseAge +
                ", requiredCreditCards=" + requiredCreditCards +
                '}';
    }
}