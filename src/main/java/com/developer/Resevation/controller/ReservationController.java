package com.developer.Resevation.controller;

import com.developer.Resevation.Service.ReservationService;
import com.developer.Resevation.Service.TotalBookingService;
import com.developer.Resevation.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        // hvis total af booking samy nye reservation er lig eller stor end 50
        if ( totalBookingService.findTotalBookingByPerformanceId(reservation.getPerformanceId())
                        + reservation.getReservationAmount() > 50){
            System.out.println("Du kan ikke reservere så mange antal");
        }
        else { return reservationService.saveReservation(reservation);}
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
