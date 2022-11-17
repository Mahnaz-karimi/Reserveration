package com.developer.Resevation.Service.impl;

import com.developer.Resevation.Service.ReservationService;
import com.developer.Resevation.entity.Reservation;
import com.developer.Resevation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }


    @Override
    public Reservation saveReservation(Reservation reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    @Override
    public Reservation updateReservation(Reservation reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
