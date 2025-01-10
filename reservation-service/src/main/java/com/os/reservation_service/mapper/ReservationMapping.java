package com.os.reservation_service.mapper;


import com.os.reservation_service.dto.request.reservation.CreateReservationRequest;
import com.os.reservation_service.dto.request.reservation.UpdateReservationRequest;
import com.os.reservation_service.dto.response.reservation.GetAllReservationResponse;
import com.os.reservation_service.model.Reservation;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservationMapping {

    ReservationMapping INSTANCE = Mappers.getMapper(ReservationMapping.class);
    // Create Reservation mapping
    Reservation createReservation(@Valid CreateReservationRequest request);

    // Update Reservation mapping
    Reservation updateReservation(@Valid UpdateReservationRequest request, @MappingTarget Reservation reservation);

    // Get All Reservations mapping
    GetAllReservationResponse getAllReservations(Reservation reservation);
    List<GetAllReservationResponse> getAllReservationToList(List<Reservation> reservationList);



}
