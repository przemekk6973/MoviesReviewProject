package dev.przemekk6973.movies.repository;

import dev.przemekk6973.movies.model.ReviewModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewModel, ObjectId> {
}
