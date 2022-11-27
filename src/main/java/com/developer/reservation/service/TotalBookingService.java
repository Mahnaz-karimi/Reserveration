package com.developer.reservation.service;

import com.developer.reservation.entity.TotalBooking;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface TotalBookingService {

    List<TotalBooking> findAllTotalBooking();
    TotalBooking findTotalBookingByPerformanceId(long id);
    Optional<TotalBooking> findById(Long id);
    TotalBooking saveTotalBooking(TotalBooking totalBooking);
    TotalBooking updateTotalBooking(TotalBooking totalBooking);
    void deleteTotalBooking(Long id);
}
