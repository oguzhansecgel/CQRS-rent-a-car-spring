package com.os.reservation_service.service.impl;

import com.os.reservation_service.client.CarClient;
import com.os.reservation_service.client.CustomerClient;
import com.os.reservation_service.dto.request.reservation.CreateReservationRequest;
import com.os.reservation_service.dto.response.reservation.CreateReservationResponse;
import com.os.reservation_service.dto.response.reservation.GetAllReservationResponse;
import com.os.reservation_service.mapper.ReservationMapping;
import com.os.reservation_service.model.CarDto;
import com.os.reservation_service.model.CustomerDto;
import com.os.reservation_service.model.Reservation;
import com.os.reservation_service.repository.ReservationRepository;
import com.os.reservation_service.service.ReservationService;
import com.os.reservation_service.util.PriceCalculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarClient carClient;
    private final CustomerClient customerClient;

    public ReservationServiceImpl(ReservationRepository reservationRepository, CarClient carClient, CustomerClient customerClient) {
        this.reservationRepository = reservationRepository;
        this.carClient = carClient;
        this.customerClient = customerClient;
    }

    @Override
    public CreateReservationResponse createReservation(CreateReservationRequest request) {
        long durationInMillis = request.getFinishTime().getTime() - request.getStartedTime().getTime();
        long durationInDays = TimeUnit.MILLISECONDS.toDays(durationInMillis);
        if(durationInDays<2)
        {
            throw new RuntimeException("Invalid duration");
        }
        CarDto car =  carClient.findByCar(request.getCarId());
        CustomerDto customer = customerClient.findByCustomer(request.getCustomerId());
        Double totalPrice = PriceCalculator.calculatePrice(request.getStartedTime(),request.getFinishTime(),car);
        Reservation reservation = ReservationMapping.INSTANCE.createReservation(request);
        reservation.setCar(car);
        reservation.setCustomer(customer);
        reservation.setPrice(totalPrice);
        Reservation savedReservation = reservationRepository.save(reservation);
        return new CreateReservationResponse(savedReservation.getId(),savedReservation.getStartedTime(),savedReservation.getFinishTime(),savedReservation.getCar().getBrandName(),savedReservation.getCustomer().getId(),savedReservation.getPickupOffice().getRentalOfficeName(),savedReservation.getDropOffOffice().getRentalOfficeName());
    }

    @Override
    public List<GetAllReservationResponse> getAllReservation() {
        List<Reservation> reservations = reservationRepository.findAll();

        return ReservationMapping.INSTANCE.getAllReservationToList(reservations);
    }
}
