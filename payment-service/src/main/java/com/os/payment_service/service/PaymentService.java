package com.os.payment_service.service;

import com.os.payment_service.dto.request.CreatePaymentRequest;

public interface PaymentService {

    void payment(CreatePaymentRequest request);
}