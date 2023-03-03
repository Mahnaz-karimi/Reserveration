package com.developer.reservation.controller;

import com.developer.reservation.entity.Performance;
import com.developer.reservation.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {
    private final PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }


    @GetMapping
    public List<Performance> findAllPerformance() {
        return performanceService.findAllPerformance();
    }

    @GetMapping("/{id}")
    public Optional<Performance> findById(@PathVariable("id") Long id) {
        return performanceService.findById(id);
    }

    @PostMapping
    public Performance savePerformance(@RequestBody Performance performance) {
        return performanceService.savePerformance(performance);
    }
    @PutMapping
    public Performance updatePerformance(@RequestBody Performance performance) {
        return performanceService.updatePerformance(performance);
    }
    @DeleteMapping("/{id}")
    public void deletePerformance(@PathVariable("id") Long id) {
        performanceService.deletePerformance(id);
    }
}
