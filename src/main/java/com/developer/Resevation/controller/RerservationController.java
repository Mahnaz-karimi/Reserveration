package com.developer.Resevation.controller;

import com.developer.Resevation.Service.ReservationService;
import com.developer.Resevation.entity.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class RerservationController {

    private final ReservationService reservationService;

    public RerservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> findAllReservation() {
        return reservationService.findAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> findReservationById(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public Reservation saveReservation(@RequestBody Reservation reservation) {
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

//    Using Request and Response with save and update employee

   /* @PostMapping("/res")
    public Reservation saveReservation(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.saveReservation(reservationRequest);
    }

    @PutMapping("/res/{id}")
    public Reservation updateRevResponse(@RequestBody ReservationRequest reservationRequest, @PathVariable("id") Long id) {
        return reservationService.updateReservation(reservationRequest, id);
    }*/
}
