// Reema Maryam Naheem 397000990
package com.nichia.reel_n_roll.model;

import jakarta.persistence.*;

@Entity
@Table(name = "showtime")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "screen_number", length = 50, nullable = false)
    private String screenNumber;

    @Column(name = "show_date", nullable = false)
    private String showDate;

    @Column(name = "show_time", nullable = false)
    private String showTime;

    public Showtime() {}

    public Showtime(Integer showId, Integer movieId, String screenNumber, String showDate, String showTime) {
        this.showId = showId;
        this.movieId = movieId;
        this.screenNumber = screenNumber;
        this.showDate = showDate;
        this.showTime = showTime;
    }

    public Integer getShowId() {
        return showId;
    }
    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getMovieId() {
        return movieId;
    }
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
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
