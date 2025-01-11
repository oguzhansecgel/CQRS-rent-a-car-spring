package com.os.payment_service.dto.request;

public class CreatePaymentRequest {
    private String reservationId;
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreatePaymentRequest() {
    }

    public CreatePaymentRequest(String reservationId, String cardNumber, String expiryDate, String cvv) {
        this.reservationId = reservationId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
