package com.os.reservation_service.client;

import com.os.reservation_service.model.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-service")
public interface CarClient {

    @GetMapping("/api/v1/search/find/by/{id}")
    CarDto findByCar(@PathVariable("id") String id);

}
