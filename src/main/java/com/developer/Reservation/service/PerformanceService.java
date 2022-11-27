package com.developer.reservation.service;

import com.developer.reservation.entity.Performance;
import com.developer.reservation.entity.Reservation;
import com.developer.reservation.entity.TotalBooking;
import com.developer.reservation.repository.TotalBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PerformanceService {

    List<Performance> findAllPerformance();
    Optional<Performance> findById(Long id);
    List<Performance> findPerformanceByDateOfPerformance(Date date);
    @Transactional
    Performance savePerformance(Performance performance);
    Performance updatePerformance(Performance performance);
    void deletePerformance(Long id);
}
