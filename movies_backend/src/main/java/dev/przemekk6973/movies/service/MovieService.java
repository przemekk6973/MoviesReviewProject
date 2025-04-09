package dev.przemekk6973.movies.service;

import dev.przemekk6973.movies.model.MovieModel;
import dev.przemekk6973.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieModel> findAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieModel> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
