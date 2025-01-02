package com.rent_a_car.car_service.query.repository;


import com.rent_a_car.car_service.query.model.Car;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarElasticSearchRepository extends ElasticsearchRepository<Car,String> {
    @Query("{\"bool\": {\"must\": [{\"wildcard\": {\"brandName\": \"?0*\"}}]}}")
    List<Car> findByBrandNameWildcard(String brandName);
}
