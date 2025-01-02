package com.rent_a_car.car_service.query.controller;

import com.rent_a_car.car_service.query.car.FindAllCarsQuery;
import com.rent_a_car.car_service.query.model.Car;
import com.rent_a_car.car_service.query.service.ElasticSearchCarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class CarSearchController {

    private final ElasticSearchCarService service;

    public CarSearchController(ElasticSearchCarService service) {
        this.service = service;
    }
    @GetMapping("/findAll/cars")
    public Iterable<FindAllCarsQuery> findAllCarsQueries()
    {
        return service.findAllCarsQuery();
    }
    @GetMapping("/cars/search")
    public List<Car> searchCars(@RequestParam String brandName) {
        return service.searchCarsByBrand(brandName);
    }
}
