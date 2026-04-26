package com.nichia.reel_n_roll.model;

// Tanya Navani - Student ID: 405008840

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    private String seatNumber;
    private String seatType;
    private boolean booked;
    private Integer theatreId;

    public Seat() {
    }

    public Seat(Integer seatId, String seatNumber, String seatType, boolean booked, Integer theatreId){
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.booked = booked;
        this.theatreId = theatreId;
    }


         public Integer getSeatId(){
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }
}