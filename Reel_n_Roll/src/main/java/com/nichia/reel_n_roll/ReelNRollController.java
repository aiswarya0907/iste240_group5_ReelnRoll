package com.nichia.reel_n_roll;

import com.nichia.reel_n_roll.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.nichia.reel_n_roll.model.Showtime;

@Controller
public class ReelNRollController {

    @Autowired
    private ReelNRollService reelNRollService;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    //
    @GetMapping("/movies")
    public String viewMovies(Model model) {
        model.addAttribute("movies", this.reelNRollService.getAllMovies());
        return "movies";
    }

    @GetMapping("/addmovie")
    public String addMovieForm() {
        return "addmovies";
    }

    @PostMapping("/addmovie")
    public String addMovie(Movie movie) {
        this.reelNRollService.addMovie(movie);
        return "redirect:/add/success/movie";
    }

    @GetMapping("/add/success/{entityName}")
    public String addSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "moviesuccess";
    }

    @GetMapping("/showtimes")
    public String viewShowtimes (Model model) {
        model.addAttribute("showtimes", this.reelNRollService.getAllShowtimes());
        return "showtimes";
    }

    @GetMapping("/addshowtime")
    public String addShowtimeForm(Model model) {
        model.addAttribute("movies", this.reelNRollService.getAllMovies());
        return "addshowtime";
    }

    @PostMapping ("/addshowtime")
    public String addShowtime(Showtime showtime) {
        this.reelNRollService.addShowtime(showtime);
        return "redirect:/add/success/showtime";
    }
}
