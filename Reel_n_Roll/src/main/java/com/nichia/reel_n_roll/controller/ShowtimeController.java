// Maryam [Your Student ID]
package com.nichia.reel_n_roll.controller;

import com.nichia.reel_n_roll.model.Showtime;
import com.nichia.reel_n_roll.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/showtime")
@CrossOrigin(origins = "*")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    @GetMapping("/search")
    public List<Showtime> search(@RequestParam(required = false) String screenNumber, @RequestParam(required = false) Integer movieId) {
        if (screenNumber != null) {
            return showtimeService.searchByScreenNumber(screenNumber);
        } else if (movieId != null) {
            return showtimeService.searchByMovieId(movieId);
        }
        return showtimeService.getAllShowtimes();
    }

    @GetMapping("/{id}")
    public Showtime getShowtimeById(@PathVariable int id) {
        return showtimeService.getShowtimeById(id);
    }

    @PostMapping
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeService.addShowtime(showtime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable int id, @RequestBody Showtime showtime) {
        return ResponseEntity.ok(showtimeService.updateShowtime(id, showtime));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable int id) {
        showtimeService.deleteShowtime(id);
        return ResponseEntity.noContent().build();
    }
}
