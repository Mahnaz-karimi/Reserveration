package com.developer.Resevation.Service;

import com.developer.Resevation.entity.TotalBooking;

import java.util.List;
import java.util.Optional;

public interface TotalBookingService {
    List<TotalBooking> findAllTotalBooking();
    int findTotalBookingAmountReservationByPerformanceId(long id);
    Optional<TotalBooking> findById(Long id);
    TotalBooking saveTotalBooking(TotalBooking totalBooking);
    TotalBooking updateTotalBooking(TotalBooking totalBooking);
    void deleteTotalBooking(Long id);
}
