package edu.uao.project.recomendationSystem.Rating;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends ReactiveMongoRepository<RatingModel, ObjectId>{

}
