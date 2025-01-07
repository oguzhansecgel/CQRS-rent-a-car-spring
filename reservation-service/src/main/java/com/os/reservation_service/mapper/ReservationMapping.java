package com.os.reservation_service.mapper;


import com.os.reservation_service.dto.request.CreateReservationRequest;
import com.os.reservation_service.model.Reservation;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapping {

    ReservationMapping INSTANCE = Mappers.getMapper(ReservationMapping.class);

    Reservation createReservation(@Valid CreateReservationRequest request);
}
