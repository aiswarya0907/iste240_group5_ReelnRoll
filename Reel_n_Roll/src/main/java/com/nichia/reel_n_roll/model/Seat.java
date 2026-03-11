package model;

import org.springframework.stereotype.Component;

@Component
public class Seat {

    private Long seatId;
    private String seatNumber;
    private String seatType;
    private boolean isBooked;

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
    public boolean getIsBooked() {
        return isBooked;
    }
    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
}
