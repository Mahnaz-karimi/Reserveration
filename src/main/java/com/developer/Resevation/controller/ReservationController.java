package com.developer.Resevation.controller;

import com.developer.Resevation.Service.ReservationService;
import com.developer.Resevation.Service.TotalBookingService;
import com.developer.Resevation.entity.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private TotalBookingService totalBookingService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
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

       /* if (totalBookingService.findTotalBookingAmountReservationByPerformanceId(reservation.getPerformanceId()) >= 50
        || totalBookingService.findTotalBookingAmountReservationByPerformanceId(reservation.getPerformanceId())
                + reservation.getReservationAmount()> 50 ){
         }*/
        return reservationService.saveReservation(reservation);
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
