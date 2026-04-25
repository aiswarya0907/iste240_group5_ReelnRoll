//Aiswarya Prasanth
//764003038

package com.nichia.reel_n_roll.service;
import com.nichia.reel_n_roll.model.Movie;
import com.nichia.reel_n_roll.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }


    public List<Movie> searchByTitle(String title) {
        return movieRepository.searchByTitle(title);
    }

    public List<Movie> searchByGenre( String genre) {
        return movieRepository.searchByGenre(genre);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    public Movie updateMovie(Integer id, Movie movieDetails) {

        Movie existingMovie = movieRepository.findById(id).orElse(null);
        if (existingMovie != null) {
            existingMovie.setTitle(movieDetails.getTitle());
            existingMovie.setGenre(movieDetails.getGenre());
            existingMovie.setRating(movieDetails.getRating());
            existingMovie.setDuration(movieDetails.getDuration());
            existingMovie.setLanguage(movieDetails.getLanguage());
            existingMovie.setDescription(movieDetails.getDescription());

            return movieRepository.save(existingMovie);
        }
        return null;
    }

    @Transactional
    public void updateMovieTitle(Integer id, String title) {
        movieRepository.updateTitleById(id, title);
    }

    @Transactional
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}


