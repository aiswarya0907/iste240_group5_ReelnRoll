//Aiswarya Prasanth
//764003038
package com.nichia.reel_n_roll.controller;
import com.nichia.reel_n_roll.model.Movie;
import com.nichia.reel_n_roll.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }


    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam(required = false) String title) {
        if (title == null || title.isEmpty()) {
            return movieService.getAllMovies();
        }
        return movieService.searchByTitle(title);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @PutMapping("/{id}/title")
    public String updateMovieTitle(@PathVariable Integer id, @RequestParam String title) {
        movieService.updateMovieTitle(id, title);
        return "Title updated to: " + title;
    }

    @GetMapping("/genre")
    public List<Movie> searchByGenre(@RequestParam String genre) {
        return movieService.searchByGenre(genre);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
        return "Movie deleted Successfully";
    }
}
