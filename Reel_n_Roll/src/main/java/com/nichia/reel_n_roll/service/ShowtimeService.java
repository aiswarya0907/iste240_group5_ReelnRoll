// Reema Maryam Naheem 397000990
package com.nichia.reel_n_roll.service;

import com.nichia.reel_n_roll.model.Showtime;
import com.nichia.reel_n_roll.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime getShowtimeById(int id) {
        return showtimeRepository.findByShowId(id);
    }

    public List<Showtime> searchByScreenNumber(String screenNumber) {
        return showtimeRepository.findByScreenNumber(screenNumber);
    }

    public List<Showtime> searchByDate(String showDate) {
        return showtimeRepository.findByShowDate(showDate);
    }

    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    public Showtime updateShowtime(int id, Showtime showtime) {
        showtime.setShowId(id);
        return showtimeRepository.save(showtime);
    }

    public void updateScreenNumber(int id, String screenNumber) {
        showtimeRepository.updateScreenNumberById(id, screenNumber);
    }

    public List<Showtime> searchByMovieId(Integer movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

    public void deleteShowtime(int id) {
        showtimeRepository.deleteById(id);
    }
}
