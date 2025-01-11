package com.os.event;

public class PaymentFailedEvent {
    private String reservationId;

    public PaymentFailedEvent() {
    }

    public PaymentFailedEvent(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
}
