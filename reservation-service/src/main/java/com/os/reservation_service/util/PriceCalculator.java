package com.os.reservation_service.util;

import com.os.reservation_service.model.CarDto;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class PriceCalculator {
    public static double calculatePrice(Date startedTime, Date finishTime, CarDto car) {
        long durationInMillis = finishTime.getTime() - startedTime.getTime();
        long durationInDays = TimeUnit.MILLISECONDS.toDays(durationInMillis);

        double totalPrice = calculateDayPriceWithDiscount(durationInDays, car.getDayPrice());

        return totalPrice;
    }

    private static double calculateDayPriceWithDiscount(long totalDays, double dayPrice) {
        double totalDayPrice = 0;

        for (long i = 0; i < totalDays; i++) {
            if (i == 0) {
                totalDayPrice += dayPrice;
            } else {

                totalDayPrice += dayPrice * (1 - 0.005 * i);
            }
        }

        return totalDayPrice;
    }
}
