package com.os.event;

public class PaymentCreatedEvent {
    private String id;

    public PaymentCreatedEvent() {
    }

    public PaymentCreatedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
