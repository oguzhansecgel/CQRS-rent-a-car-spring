package com.rent_a_car.car_service.query.service;

import com.rent_a_car.car_service.event.car.CarCreatedEvent;
import com.rent_a_car.car_service.query.car.FindAllCarsQuery;
import com.rent_a_car.car_service.query.mapper.CarMapping;
import com.rent_a_car.car_service.query.model.Car;
import com.rent_a_car.car_service.query.repository.CarElasticSearchRepository;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchCarService {

    private final CarElasticSearchRepository repository;

    public ElasticSearchCarService(CarElasticSearchRepository repository) {
        this.repository = repository;
    }

    public Iterable<FindAllCarsQuery> findAllCarsQuery()
    {
        Iterable<Car> findAll = repository.findAll();
        return CarMapping.INSTANCE.findAllCarsOueryToList(findAll);
    }
    public void createCarElasticSearchDB(CarCreatedEvent event)
    {
        Car car = new Car();
        car.setName(event.getName());
        car.setBrandName(event.getBrandName());
        repository.save(car);
    }

}
