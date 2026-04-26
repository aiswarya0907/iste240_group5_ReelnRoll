package com.nichia.reel_n_roll.controller;

// Tanya Navani - Student ID: 405008840

import com.nichia.reel_n_roll.model.Seat;
import com.nichia.reel_n_roll.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "*")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Integer id) {
        return seatService.getSeatById(id);
    }

    @GetMapping("/search")
    public List<Seat> searchSeats(@RequestParam(required = false) String seatNumber) {
        if (seatNumber == null || seatNumber.isEmpty()) {
            return seatService.getAllSeats();
        }
        return seatService.searchBySeatNumber(seatNumber);
    }

    @GetMapping("/type")
    public List<Seat> searchBySeatType(@RequestParam String seatType) {
        return seatService.searchBySeatType(seatType);
    }

    @GetMapping("/booked")
    public List<Seat> searchByBookedStatus(@RequestParam boolean booked) {
        return seatService.searchByBookedStatus(booked);
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return seatService.createSeat(seat);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Integer id, @RequestBody Seat seat) {
        return seatService.updateSeat(id, seat);
    }

    @PutMapping("/{id}/booked")
    public String updateBookedStatus(@PathVariable Integer id, @RequestParam boolean booked) {
        seatService.updateBookedStatus(id, booked);
        return "Seat booking status updated to: " + booked;
    }

    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeat(id);
        return "Seat deleted successfully";
    }
}