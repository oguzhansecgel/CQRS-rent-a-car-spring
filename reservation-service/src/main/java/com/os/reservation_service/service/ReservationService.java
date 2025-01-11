package com.os.reservation_service.service;

import com.os.reservation_service.dto.request.reservation.CreateReservationRequest;
import com.os.reservation_service.dto.response.reservation.CreateReservationResponse;
import com.os.reservation_service.dto.response.reservation.GetAllReservationResponse;

import java.util.List;

public interface ReservationService {

    CreateReservationResponse createReservation(CreateReservationRequest request);

    List<GetAllReservationResponse> getAllReservation();

    void deleteReservation(String reservationId);
}
