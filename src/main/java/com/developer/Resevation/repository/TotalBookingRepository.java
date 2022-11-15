package com.developer.Resevation.repository;

import com.developer.Resevation.entity.TotalBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalBookingRepository extends JpaRepository<TotalBooking, Long> {
}
