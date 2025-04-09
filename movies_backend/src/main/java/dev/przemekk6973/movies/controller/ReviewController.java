package dev.przemekk6973.movies.controller;

import dev.przemekk6973.movies.model.ReviewModel;
import dev.przemekk6973.movies.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewModel> createReview(@RequestBody Map<String, String> payload) {
        String reviewBody = payload.get("reviewBody");
        String imdbId = payload.get("imdbId");
        ReviewModel createdReviewModel = reviewService.createReview(reviewBody, imdbId);
        return ResponseEntity.ok(createdReviewModel);
    }
}
