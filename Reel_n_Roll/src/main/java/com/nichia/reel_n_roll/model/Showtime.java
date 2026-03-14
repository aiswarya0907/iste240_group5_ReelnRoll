package com.nichia.reel_n_roll.model;

public class Showtime {
    private int showId;
    private Movie movie;

    private String screenNumber;
    private String showDate;
    private String showTime;

    public Showtime() {}

    public Showtime(int showId, Movie movie, String screenNumber, String showDate, String showTime)
    {
        this.showId = showId;
        this.movie= movie;
        this.screenNumber = screenNumber;
        this.showDate = showDate;
        this.showTime = showTime;
    }

    public int getShowId() {
        return showId;
    }
    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getScreenNumber() {
        return screenNumber;
    }
    public void setScreenNumber(String screenNumber) {
        this.screenNumber = screenNumber;
    }

    public String getShowDate() {
        return showDate;
    }
    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}

