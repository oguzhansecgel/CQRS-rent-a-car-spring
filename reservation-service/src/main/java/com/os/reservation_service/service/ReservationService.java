package com.os.reservation_service.service;

import com.os.reservation_service.dto.request.CreateReservationRequest;
import com.os.reservation_service.model.Reservation;

public interface ReservationService {

    void createReservation(CreateReservationRequest request);
}
