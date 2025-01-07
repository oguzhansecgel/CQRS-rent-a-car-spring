package com.os.reservation_service.client;

import com.os.reservation_service.model.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/api/v1/auth/get/by/{id}")
    CustomerDto findByCustomer(@PathVariable int id);
}
