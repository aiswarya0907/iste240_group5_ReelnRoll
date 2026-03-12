package com.nichia.reel_n_roll;
import com.nichia.reel_n_roll.model.Movie;
import com.nichia.reel_n_roll.model.Showtime;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.nichia.reel_n_roll.model.Theatre;

@Service
public class ReelNRollService {
    private List<Movie> movies = new ArrayList<>();
    private List <Showtime> showtimes = new ArrayList<>();
    private List<Theatre> theatres = new ArrayList<>();

    public ReelNRollService() {
            movies.add(new Movie(1, "Inception", "Sci-Fi", "English", 148, "PG-13", "A mind-bending thriller"));
            movies.add(new Movie(2, "Parasite", "Thriller", "Korean", 132, "R", "A class struggle story"));
            movies.add(new Movie(3, "Interstellar", "Sci-Fi", "English", 169, "PG-13", "A space odyssey"));
            showtimes.add(new Showtime(1, movies.get(0), "Screen 1", "18-03-2026", "5:00 PM"));
            showtimes.add(new Showtime(2, movies.get(1), "Screen 2", "20-03-2026", "6:00 PM"));
            showtimes.add(new Showtime(3, movies.get(2), "Screen 3", "23-03-2026", "7:30 PM"));
            Theatre t1 = new Theatre();
            t1.setTheatreId(1L);
            t1.setTheatreName("Reel Cinemas");
            t1.setLocation("Dubai Mall");
            t1.setTotalScreens(12);

            Theatre t2 = new Theatre();
            t2.setTheatreId(2L);
            t2.setTheatreName("VOX Cinemas");
            t2.setLocation("Mall of the Emirates");
            t2.setTotalScreens(10);

            theatres.add(t1);
            theatres.add(t2);
        }
        public List<Movie> getAllMovies() { return movies; }
        public void addMovie(Movie m) { movies.add(m); }
        public List<Showtime> getAllShowtimes() { return showtimes; }
        public void addShowtime (Showtime s) { showtimes.add(s); }

        public List<Theatre> getAllTheatres() {
            return theatres;
        }

        public void addTheatre(Theatre t) {
            theatres.add(t);
        }


}

