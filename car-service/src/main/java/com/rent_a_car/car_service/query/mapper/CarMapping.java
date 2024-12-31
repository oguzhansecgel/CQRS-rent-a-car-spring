package com.rent_a_car.car_service.query.mapper;

import com.rent_a_car.car_service.query.car.FindAllCarsQuery;
import com.rent_a_car.car_service.query.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapping {

    CarMapping INSTANCE = Mappers.getMapper(CarMapping.class);

    FindAllCarsQuery findAllCarsQuery(Car car);
    Iterable<FindAllCarsQuery> findAllCarsOueryToList(Iterable<Car> cars);
}
