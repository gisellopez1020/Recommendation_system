package edu.uao.project.recomendationSystem.RatingCurso;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingCursoRepository extends ReactiveMongoRepository<RatingCursoModel, ObjectId>{

}
