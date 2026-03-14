package com.nichia.reel_n_roll;
import com.nichia.reel_n_roll.model.Movie;
import com.nichia.reel_n_roll.model.Showtime;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.nichia.reel_n_roll.model.Theatre;
import com.nichia.reel_n_roll.model.Seat;

@Service
public class ReelNRollService {
    private List<Movie> movies = new ArrayList<>();
    private List <Showtime> showtimes = new ArrayList<>();
    private List<Theatre> theatres = new ArrayList<>();
    private List<Seat> seats = new ArrayList<>();

    public ReelNRollService() {
            movies.add(new Movie(1, "Inception", "Sci-Fi", "English", 148, "PG-13", "A mind-bending thriller"));
            movies.add(new Movie(2, "Parasite", "Thriller", "Korean", 132, "R", "A class struggle story"));
            movies.add(new Movie(3, "Interstellar", "Sci-Fi", "English", 169, "PG-13", "A space odyssey"));
            showtimes.add(new Showtime(1, movies.get(0), "Screen 1", "18-03-2026", "5:00 PM"));
            showtimes.add(new Showtime(2, movies.get(1), "Screen 2", "20-03-2026", "6:00 PM"));
            showtimes.add(new Showtime(3, movies.get(2), "Screen 3", "23-03-2026", "7:30 PM"));


            Theatre t1 = new Theatre(1L, "Reel Cinemas", "Dubai Mall", 12);
            Theatre t2 = new Theatre(2L, "VOX Cinemas", "Mall of the Emirates", 10);

            theatres.add(t1);
            theatres.add(t2);

        seats.add(new Seat(1L, "A1", "VIP", false, t1));
        seats.add(new Seat(2L, "A2", "VIP", false, t1));
        seats.add(new Seat(3L, "B1", "Standard", false, t2));
        seats.add(new Seat(4L, "B2", "Standard", true, t2));
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
    public List<Seat> getAllSeats() { return seats; }
    public void addSeat(Seat seat) { seats.add(seat); }


}

