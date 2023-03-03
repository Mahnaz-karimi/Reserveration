package com.developer.reservation.service.impl;

import com.developer.reservation.entity.Performance;
import com.developer.reservation.repository.PerformanceRepository;
import com.developer.reservation.service.PerformanceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;

    public PerformanceServiceImpl(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;

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
    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
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
