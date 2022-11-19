package com.developer.reservation.controller;

import com.developer.reservation.service.ReservationService;
import com.developer.reservation.service.TotalBookingService;
import com.developer.reservation.entity.Reservation;
import com.developer.reservation.entity.TotalBooking;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final TotalBookingService totalBookingService;

    public ReservationController(ReservationService reservationService, TotalBookingService totalBookingService) {
        this.reservationService = reservationService;
        this.totalBookingService = totalBookingService;
    }
    @GetMapping
    public List<Reservation> findAllReservation() {
        return reservationService.findAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> findById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        TotalBooking tb = totalBookingService.findTotalBookingByPerformanceId(reservation.getPerformanceId());

        int totalBookingAmountPlusNewReservationAmount = tb.getTotalBooking() + reservation.getReservationAmount();
        if ( reservation.getReservationAmount() > 50)
        {
            System.out.println("Der er kun 50 pladser i alt");
        }
        else if ( totalBookingAmountPlusNewReservationAmount > 50 ){

            System.out.println("Du kan ikke reservere på dette antal pladser");
        }
        else {

            Reservation r = reservationService.saveReservation(reservation);

            tb.setTotalBooking(totalBookingAmountPlusNewReservationAmount);
            totalBookingService.updateTotalBooking(tb);
            return r;
        }

        return null;
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservationEntity) {
        return reservationService.updateReservation(reservationEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
    }

}
