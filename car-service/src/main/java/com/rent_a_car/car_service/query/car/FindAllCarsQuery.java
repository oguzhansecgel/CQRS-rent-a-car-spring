package com.rent_a_car.car_service.query.car;

public class FindAllCarsQuery {

    private String id;

    private String name;

    private String brandName;

    public FindAllCarsQuery(String id, String name, String brandName) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
    }

    public FindAllCarsQuery() {
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
