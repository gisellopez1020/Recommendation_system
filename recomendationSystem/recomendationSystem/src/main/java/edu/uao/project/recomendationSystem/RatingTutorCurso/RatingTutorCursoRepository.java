package edu.uao.project.recomendationSystem.RatingTutorCurso;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingTutorCursoRepository extends ReactiveMongoRepository<RatingTutorCursoModel, ObjectId> {

}
