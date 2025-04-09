package dev.przemekk6973.movies.repository;

import dev.przemekk6973.movies.model.MovieModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<MovieModel, ObjectId> {
    Optional<MovieModel> findMovieByImdbId(String imdbId);
}
