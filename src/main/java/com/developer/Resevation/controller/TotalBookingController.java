package com.developer.Resevation.controller;

import com.developer.Resevation.Service.TotalBookingService;
import com.developer.Resevation.entity.TotalBooking;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sumBooking")
public class TotalBookingController {

    private final TotalBookingService totalBookingService;

    public TotalBookingController(TotalBookingService totalBookingService) {
        this.totalBookingService = totalBookingService;
    }

    @GetMapping
    public List<TotalBooking> findAllTotalBooking() {
        return totalBookingService.findAllTotalBooking();
    }

    @GetMapping("/{id}")
    public Optional<TotalBooking> findById(@PathVariable("id") Long id) {
        return totalBookingService.findById(id);
    }

    @PostMapping
    public TotalBooking saveTotalBooking(@RequestBody TotalBooking totalBooking) {
        return totalBookingService.saveTotalBooking(totalBooking);
    }
    @DeleteMapping("/{id}")
    public void deleteTotalBooking(@PathVariable("id") Long id) {
        totalBookingService.deleteTotalBooking(id);
    }
}
