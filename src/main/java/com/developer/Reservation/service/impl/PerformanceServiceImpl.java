package com.developer.reservation.service.impl;

import com.developer.reservation.entity.Performance;
import com.developer.reservation.entity.TotalBooking;
import com.developer.reservation.repository.PerformanceRepository;
import com.developer.reservation.service.PerformanceService;
import com.developer.reservation.service.TotalBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;

    @Autowired
    private final TotalBookingService totalBookingService ;

    public PerformanceServiceImpl(PerformanceRepository performanceRepository, TotalBookingService totalBookingService) {
        this.performanceRepository = performanceRepository;
        this.totalBookingService = totalBookingService;
    }
    @Override
    public List<Performance> findAllPerformance() {
        return performanceRepository.findAll();
    }

    @Override
    public Optional<Performance> findById(Long id) {
        return performanceRepository.findById(id);
    }

    @Override
    public List <Performance> findPerformanceByDateOfPerformance(Date date) {
        return performanceRepository.findPerformanceByDateOfPerformance(date);
    }

    @Override
    @Transactional
    public Performance savePerformance(Performance performance) {
        Performance p = performanceRepository.save(performance);
        TotalBooking t = new TotalBooking(0,p);
        totalBookingService.saveTotalBooking(t);
        return p;
    }

    @Override
    public Performance updatePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
}
