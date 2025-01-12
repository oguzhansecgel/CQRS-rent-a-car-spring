package com.os.payment_service.repository;

import com.os.payment_service.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByReservationId(String reservationId);
}
