package com.os.reservation_service.controller;

import com.os.reservation_service.dto.request.reservation.CreateReservationRequest;
import com.os.reservation_service.dto.response.reservation.GetAllReservationResponse;
import com.os.reservation_service.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping("/get/all/reservation")
    public List<GetAllReservationResponse> getAllReservationResponseList()
    {
        return reservationService.getAllReservation();
    }
    @PostMapping("/create/reservation")
    public void createReservation(@RequestBody CreateReservationRequest createReservationRequest)
    {
        reservationService.createReservation(createReservationRequest);
    }
}
