package com.nichia.reel_n_roll;
import com.nichia.reel_n_roll.model.Movie;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReelNRollService {
    private List<Movie> movies = new ArrayList<>();

    public ReelNRollService() {
            movies.add(new Movie(1, "Inception", "Sci-Fi", "English", 148, "PG-13", "A mind-bending thriller"));
            movies.add(new Movie(2, "Parasite", "Thriller", "Korean", 132, "R", "A class struggle story"));
            movies.add(new Movie(3, "Interstellar", "Sci-Fi", "English", 169, "PG-13", "A space odyssey"));
        }
        public List<Movie> getAllMovies() { return movies; }
        public void addMovie(Movie m) { movies.add(m); }

}

