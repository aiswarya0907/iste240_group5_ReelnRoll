package com.nichia.reel_n_roll.model;

import jakarta.persistence.*;

@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    private String theatreName;
    private String location;
    private int totalScreens;

    public Theatre() {}

    public Theatre(Long theatreId, String theatreName, String location, int totalScreens) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.location = location;
        this.totalScreens = totalScreens;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public void setTotalScreens(int totalScreens) {
        this.totalScreens = totalScreens;
    }
}