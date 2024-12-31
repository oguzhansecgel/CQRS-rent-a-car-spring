package com.rent_a_car.car_service.query.exception;

import com.rent_a_car.car_service.query.exception.error.ApiError;
import com.rent_a_car.car_service.query.exception.type.BrandNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ApiError> handleCategoryNotFoundException(BrandNotFoundException exception, HttpServletRequest request)
    {
        ApiError apiError  = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setPath(request.getRequestURI());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
