package com.nichia.reel_n_roll.controller;

// Tanya Navani - Student ID: 405008840
import com.nichia.reel_n_roll.model.Seat;
import com.nichia.reel_n_roll.service.SeatService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Seat> searchSeats(
            @RequestParam(required = false) String seatNumber,
            @RequestParam(required = false) String seatType,
            @RequestParam(required = false) Boolean booked) {

        if (seatNumber != null && !seatNumber.isBlank()) {
            return seatService.searchBySeatNumber(seatNumber);
        }

        if (seatType != null && !seatType.isBlank()) {
            return seatService.searchBySeatType(seatType);
        }

        if (booked != null) {
            return seatService.searchByBookedStatus(booked);
        }

        return seatService.getAllSeats();
    }

    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return seatService.createSeat(seat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat updatedSeat) {
        return seatService.updateSeat(id, updatedSeat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/booked")
    public ResponseEntity<String> updateBookedStatus(
            @PathVariable Long id,
            @RequestParam boolean booked) {

        int updatedRows = seatService.updateBookedStatus(id, booked);

        if (updatedRows > 0) {
            return ResponseEntity.ok("Seat booking status updated successfully.");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable Long id) {
        boolean deleted = seatService.deleteSeat(id);

        if (deleted) {
            return ResponseEntity.ok("Seat deleted successfully.");
        }

        return ResponseEntity.notFound().build();
    }
}