package com.nichia.reel_n_roll.model;

public class Seat {

    private Long seatId;
    private String seatNumber;
    private String seatType;
    private boolean isBooked;
    private Theatre theatre;

    public Seat() {
        this.theatre = new Theatre();
    }

    public Seat(Long seatId, String seatNumber, String seatType, boolean isBooked, Theatre theatre) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isBooked = isBooked;
        this.theatre = theatre;

    }

    public Long getSeatId() {
        return seatId;
    }
    public void setSeatId(Long seatId) {
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
        return isBooked;
    }
    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Theatre getTheatre() { return theatre; }
    public void setTheatre(Theatre theatre) { this.theatre = theatre; }



}
