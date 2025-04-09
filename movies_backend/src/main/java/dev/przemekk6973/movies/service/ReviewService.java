package dev.przemekk6973.movies.service;

import dev.przemekk6973.movies.model.MovieModel;
import dev.przemekk6973.movies.model.ReviewModel;
import dev.przemekk6973.movies.repository.MovieRepository;
import dev.przemekk6973.movies.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public ReviewModel createReview(String reviewBody, String imdbId) {
        // Utworzenie nowej recenzji
        ReviewModel reviewModel = new ReviewModel(reviewBody, LocalDateTime.now(), LocalDateTime.now());
        reviewModel = reviewRepository.insert(reviewModel);

        // Powiązanie recenzji z filmem
        Optional<MovieModel> movieOptional = movieRepository.findMovieByImdbId(imdbId);
        if (movieOptional.isPresent()) {
            MovieModel movieModel = movieOptional.get();
            if (movieModel.getReviews() == null) {
                movieModel.setReviews(new ArrayList<>());
            }
            movieModel.getReviews().add(reviewModel);
            movieRepository.save(movieModel);
        }
        return reviewModel;
    }
}
