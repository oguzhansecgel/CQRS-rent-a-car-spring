package com.os.payment_service.controller;

import com.os.payment_service.dto.request.CreatePaymentRequest;
import com.os.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/create/payment")
    public void createPayment(@RequestBody CreatePaymentRequest request)
    {
        paymentService.payment(request);
    }
}
