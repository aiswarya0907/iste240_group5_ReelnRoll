package com.nichia.reel_n_roll.service;

// Tanya Navani - Student ID: 405008840

import com.nichia.reel_n_roll.model.Seat;
import com.nichia.reel_n_roll.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(Integer id) {
        return seatRepository.findById(id).orElse(null);
    }

    public List<Seat> searchBySeatNumber(String seatNumber) {
        return seatRepository.findBySeatNumberContainingIgnoreCase(seatNumber);
    }

    public List<Seat> searchBySeatType(String seatType) {
        return seatRepository.findBySeatTypeContainingIgnoreCase(seatType);
    }

    public List<Seat> searchByBookedStatus(boolean booked) {
        return seatRepository.findByBooked(booked);
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Integer id, Seat seatDetails) {

        Seat existingSeat = seatRepository.findById(id).orElse(null);

        if (existingSeat != null) {
            existingSeat.setSeatNumber(seatDetails.getSeatNumber());
            existingSeat.setSeatType(seatDetails.getSeatType());
            existingSeat.setBooked(seatDetails.isBooked());
            existingSeat.setTheatreId(seatDetails.getTheatreId());

            return seatRepository.save(existingSeat);
        }

        return null;
    }

    public boolean deleteSeat(Integer id) {
        if (seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int updateBookedStatus(Integer id, boolean booked) {
        return seatRepository.updateBookedBySeatId(id, booked);
    }
}