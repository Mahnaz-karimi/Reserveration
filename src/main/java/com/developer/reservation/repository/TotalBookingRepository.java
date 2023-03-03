package com.developer.reservation.repository;

import com.developer.reservation.entity.TotalBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalBookingRepository extends JpaRepository<TotalBooking, Long> {
    TotalBooking findTotalBookingByPerformanceId(long performanceId); // transaktioner
}

