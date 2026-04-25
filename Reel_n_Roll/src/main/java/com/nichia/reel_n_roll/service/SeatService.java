package com.nichia.reel_n_roll.service;

// Tanya Navani - Student ID: 405008840

import com.nichia.reel_n_roll.model.Seat;
import com.nichia.reel_n_roll.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }

    public List<Seat> searchBySeatNumber(String seatNumber) {
        return seatRepository.findBySeatNumberContainingIgnoreCase(seatNumber);
    }

    public List<Seat> searchBySeatType(String seatType) {
        return seatRepository.findBySeatTypeContainingIgnoreCase(seatType);
    }

    public List<Seat> searchByBookedStatus(boolean booked) {
        return seatRepository.findSeatsByBookedStatus(booked);
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Optional<Seat> updateSeat(Long id, Seat updatedSeat) {
        return seatRepository.findById(id).map(existingSeat -> {
            existingSeat.setSeatNumber(updatedSeat.getSeatNumber());
            existingSeat.setSeatType(updatedSeat.getSeatType());
            existingSeat.setBooked(updatedSeat.isBooked());
            existingSeat.setTheatreId(updatedSeat.getTheatreId());
            return seatRepository.save(existingSeat);
        });
    }

    public boolean deleteSeat(Long id) {
        if (seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int updateBookedStatus(Long id, boolean booked) {
        return seatRepository.updateBookedBySeatId(id, booked);
    }
}