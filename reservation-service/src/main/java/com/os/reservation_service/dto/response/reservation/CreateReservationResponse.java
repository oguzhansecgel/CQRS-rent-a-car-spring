package com.os.reservation_service.dto.response.reservation;

import java.util.Date;

public class CreateReservationResponse {
    private String id;
    private Date startedTime;
    private Date finishTime;
    private String carId;
    private int customerId;
    private Double price;
    public CreateReservationResponse() {
    }

    public CreateReservationResponse(String id, Date startedTime, Date finishTime, String carId, int customerId, Double price) {
        this.id = id;
        this.startedTime = startedTime;
        this.finishTime = finishTime;
        this.carId = carId;
        this.customerId = customerId;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(Date startedTime) {
        this.startedTime = startedTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
