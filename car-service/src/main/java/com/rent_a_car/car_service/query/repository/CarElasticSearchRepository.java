package com.rent_a_car.car_service.query.repository;


import com.rent_a_car.car_service.query.model.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarElasticSearchRepository extends ElasticsearchRepository<Car,String> {
}
