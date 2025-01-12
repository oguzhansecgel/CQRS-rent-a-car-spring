package com.os.event;

public class ReservationCreatedEvent {
    private String reservationId;
    private Double totalPrice;

    public ReservationCreatedEvent(String reservationId, Double totalPrice ) {
        this.reservationId = reservationId;
        this.totalPrice = totalPrice;
    }

    public ReservationCreatedEvent() {
    }


    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
