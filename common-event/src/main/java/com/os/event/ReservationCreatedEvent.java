package com.os.event;

public class ReservationCreatedEvent {
    private String reservationId;

    public ReservationCreatedEvent(String reservationId) {
        this.reservationId = reservationId;
    }

    public ReservationCreatedEvent() {
    }


    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }


}
