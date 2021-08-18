package com.linkedinlearning.reactivespring.controller;

import com.linkedinlearning.reactivespring.model.Reservation;
import com.linkedinlearning.reactivespring.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_VI_RESERVATION)
@CrossOrigin
public class ReservationResource {

    public static final String ROOM_VI_RESERVATION = "/room/v1/reservation/";

    private final ReservationService reservationService;

    @Autowired
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String id) {
        return reservationService.getReservation(id);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> updatePrice(@PathVariable String id, @RequestBody Mono<Reservation> reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping(path = "{id}")
    public Mono<Boolean> deleteReservation(@PathVariable String id) {
        return reservationService.deleteReservation(id);
    }
}
