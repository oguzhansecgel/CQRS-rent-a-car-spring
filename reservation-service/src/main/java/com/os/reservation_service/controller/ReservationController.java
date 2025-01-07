package com.os.reservation_service.controller;

import com.os.reservation_service.dto.request.CreateReservationRequest;
import com.os.reservation_service.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create/reservation")
    public void createReservation(@RequestBody CreateReservationRequest createReservationRequest)
    {
        reservationService.createReservation(createReservationRequest);
    }
}
