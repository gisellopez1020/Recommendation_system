package edu.uao.project.recomendationSystem.Tutor;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends ReactiveMongoRepository<TutorModel, ObjectId> {

}
