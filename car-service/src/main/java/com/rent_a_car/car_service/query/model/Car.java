package com.rent_a_car.car_service.query.model;


import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "cars")
public class Car {

    @Id
    private String id;

    private String name;

    private String brandName;

    public Car() {
    }

    public Car(String id, String name, String brandName) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
