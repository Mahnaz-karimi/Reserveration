package com.developer.reservation.service;

import com.developer.reservation.entity.Performance;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PerformanceService {

    List<Performance> findAllPerformance();
    Optional<Performance> findById(Long id);
    List<Performance> findPerformanceByDateOfPerformance(Date date);
    Performance savePerformance(Performance performance);
    Performance updatePerformance(Performance performance);
    void deletePerformance(Long id);
}
