package dev.przemekk6973.movies.controller;

import dev.przemekk6973.movies.model.MovieModel;
import dev.przemekk6973.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieModel>> getMovies() {
        List<MovieModel> movieModels = movieService.findAllMovies();
        return ResponseEntity.ok(movieModels);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<MovieModel> getMovieByImdbId(@PathVariable String imdbId) {
        Optional<MovieModel> movieOptional = movieService.findMovieByImdbId(imdbId);
        return movieOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
