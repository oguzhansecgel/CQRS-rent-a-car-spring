package com.os.reservation_service.dto.request.reservation;


import java.util.Date;

public class CreateReservationRequest {
    private Date startedTime;
    private Date finishTime;
    private String carId;
    private int customerId;

    public CreateReservationRequest() {
    }

    public CreateReservationRequest(Date startedTime, Date finishTime, String carId, int customerId) {
        this.startedTime = startedTime;
        this.finishTime = finishTime;
        this.carId = carId;
        this.customerId = customerId;
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
