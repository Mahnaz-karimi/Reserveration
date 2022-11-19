package com.developer.reservation.repository;

import com.developer.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findReservationByCostumerId (long costumerId);
    Reservation findReservationByPerformanceId(long performanceID);

}
