package com.rent_a_car.car_service.query.mapper;

import com.rent_a_car.car_service.query.car.FindAllCarsQuery;
import com.rent_a_car.car_service.query.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapping {

    CarMapping INSTANCE = Mappers.getMapper(CarMapping.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "seatCount", source = "seatCount")
    @Mapping(target = "luggageCapacity", source = "luggageCapacity")
    @Mapping(target = "passengerAirbag", source = "passengerAirbag")
    @Mapping(target = "abs", source = "abs")
    @Mapping(target = "fuelType", source = "fuelType")
    @Mapping(target = "transmissionType", source = "transmissionType")
    @Mapping(target = "brandName", source = "brandName")
    @Mapping(target = "minimumAge", source = "minimumAge")
    @Mapping(target = "minimumLicenseAge", source = "minimumLicenseAge")
    @Mapping(target = "requiredCreditCards", source = "requiredCreditCards")
    FindAllCarsQuery findAllCarsQuery(Car car);
    Iterable<FindAllCarsQuery> findAllCarsOueryToList(Iterable<Car> cars);
}
