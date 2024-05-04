package edu.uao.project.recomendationSystem.Curso;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends ReactiveMongoRepository<CursoModel, ObjectId> {

}
