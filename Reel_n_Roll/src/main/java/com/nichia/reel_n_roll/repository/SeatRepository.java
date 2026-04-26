package com.nichia.reel_n_roll.repository;

// Tanya Navani - Student ID: 405008840

import com.nichia.reel_n_roll.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findBySeatNumberContainingIgnoreCase(String seatNumber);

    List<Seat> findBySeatTypeContainingIgnoreCase(String seatType);

    @Query("SELECT s FROM Seat s WHERE s.booked = :booked")
    List<Seat> findByBooked(boolean booked);

    @Modifying
    @Transactional
    @Query("UPDATE Seat s SET s.booked = :booked WHERE s.seatId = :seatId")
    int updateBookedBySeatId(Integer seatId, boolean booked);
}