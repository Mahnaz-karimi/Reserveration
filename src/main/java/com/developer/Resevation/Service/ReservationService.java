package com.developer.Resevation.Service;

import com.developer.Resevation.entity.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAllReservation();
    Optional<Reservation> findById(Long id);
    Reservation saveReservation(Reservation reservationEntity);
    Reservation updateReservation(Reservation reservationEntity);
    void deleteReservation(Long id);

}
