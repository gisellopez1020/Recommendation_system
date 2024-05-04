package edu.uao.project.recomendationSystem.TutorCurso;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorCursoRepository extends ReactiveMongoRepository<TutorCursoModel, Integer> {

}
