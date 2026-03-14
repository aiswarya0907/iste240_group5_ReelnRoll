package com.nichia.reel_n_roll;
import com.nichia.reel_n_roll.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.nichia.reel_n_roll.model.Showtime;
import com.nichia.reel_n_roll.model.Theatre;
import com.nichia.reel_n_roll.model.Seat;

@Controller
public class ReelNRollController {

    @Autowired
    private ReelNRollService reelNRollService;

    @GetMapping("/")
    public String home() {
        return "index";
   }

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

    @PostMapping("/addshowtime")
    public String addShowtime(Showtime showtime, @RequestParam int movieId) {
        Movie movie = this.reelNRollService.getAllMovies()
                .stream()
                .filter(m -> m.getId() == movieId)
                .findFirst()
                .orElse(null);
        showtime.setMovie(movie);
        this.reelNRollService.addShowtime(showtime);
        return "redirect:/add/success/showtime";
    }

    @GetMapping("/theatre")
    public String viewTheatres(Model model) {
        model.addAttribute("theatres", this.reelNRollService.getAllTheatres());
        return "theatre"; // must match theatre.mustache in templates folder
    }

    @GetMapping("/addtheatre")
    public String addTheatreForm(Model model) {
        model.addAttribute("theatre", new Theatre());
        return "add-theatre"; // matches add-theatre.mustache
    }


    @PostMapping("/addtheatre")
    public String addTheatreSubmit(@ModelAttribute Theatre theatre) {
        this.reelNRollService.addTheatre(theatre);
        return "redirect:/add/success/theatre"; // success page for theatre
    }

    @GetMapping("/seats")
    public String viewSeats(Model model) {
        model.addAttribute("seats", reelNRollService.getAllSeats());
        return "seats";
    }

    @GetMapping("/seats/add")
    public String addSeatForm(Model model) {
        model.addAttribute("theatres", reelNRollService.getAllTheatres());
        return "add-seat";
    }

    @PostMapping("/seats/add")
    public String addSeat(@ModelAttribute Seat seat) {
        reelNRollService.addSeat(seat);
        return "redirect:/add/success/seat";
    }

    @GetMapping("/add/success/{entityName}")
    public String addSuccess(@PathVariable String entityName, Model model) {
        model.addAttribute("entityName", entityName);
        return "success";
    }

}



