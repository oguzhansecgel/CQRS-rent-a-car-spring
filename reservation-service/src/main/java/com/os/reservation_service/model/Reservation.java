package com.os.reservation_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "reservation")
public class Reservation {

    @Id
    private String id;
    private Date startedTime;
    private Date finishTime;
    private Double price;
    private CarDto car;
    private CustomerDto customer;
    public Reservation() {
    }

    public Reservation(String id, Date startedTime, Date finishTime, Double price, CarDto car, CustomerDto customer) {
        this.id = id;
        this.startedTime = startedTime;
        this.finishTime = finishTime;
        this.price = price;
        this.car = car;
        this.customer = customer;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }


}
