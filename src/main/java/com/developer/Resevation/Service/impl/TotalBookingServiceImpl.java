package com.developer.Resevation.Service.impl;

import com.developer.Resevation.Service.TotalBookingService;
import com.developer.Resevation.entity.Reservation;
import com.developer.Resevation.entity.TotalBooking;
import com.developer.Resevation.repository.TotalBookingRepository;

import java.util.List;
import java.util.Optional;

public class TotalBookingServiceImpl implements TotalBookingService {

    private final TotalBookingRepository totalBookingRepository;

    public TotalBookingServiceImpl(TotalBookingRepository totalBookingRepository) {
        this.totalBookingRepository = totalBookingRepository;
    }

    @Override
    public List<TotalBooking> findAllTotalBooking() {
        return totalBookingRepository.findAll();
    }

    @Override
    public int findTotalBookingAmountReservationByPerformanceId(long id) {
        return  0; // methd for at finde en totalbooking via performance id
    }

    @Override
    public Optional<TotalBooking> findById(Long id) {
        return totalBookingRepository.findById(id);
    }

    @Override
    public TotalBooking saveTotalBooking(TotalBooking totalBooking) {
        return totalBookingRepository.save(totalBooking);
    }

    @Override
    public TotalBooking updateTotalBooking(TotalBooking totalBooking) {
        return totalBookingRepository.save(totalBooking);
    }

    @Override
    public void deleteTotalBooking(Long id) {
        totalBookingRepository.deleteById(id);
    }
}
