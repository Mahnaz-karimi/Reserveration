package com.developer.reservation.service.impl;

import com.developer.reservation.entity.Reservation;
import com.developer.reservation.service.TotalBookingService;
import com.developer.reservation.entity.TotalBooking;
import com.developer.reservation.repository.TotalBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TotalBookingServiceImpl implements TotalBookingService {
    private TotalBookingRepository totalBookingRepository;
    public TotalBookingServiceImpl(TotalBookingRepository totalBookingRepository) {
        this.totalBookingRepository = totalBookingRepository;
    }

    @Override
    public List<TotalBooking> findAllTotalBooking() {
        return totalBookingRepository.findAll();
    }

    @Override
    public TotalBooking findTotalBookingByPerformanceId(long id) {
        return  totalBookingRepository.findTotalBookingByPerformanceId(id);
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
