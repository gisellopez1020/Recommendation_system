package edu.uao.project.recomendationSystem.RatingCurso;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Criteria;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RatingCursoService {
    @Autowired
    private RatingCursoRepository rcRepository;

    public Flux<RatingCursoModel> allRatingsCourses(){
        return this.rcRepository.findAll();
    }

    public Mono<RatingCursoModel> addRatingsCourses(RatingCursoModel ratingC){
        return this.rcRepository.save(ratingC);
    }

    public Mono<RatingCursoModel> updateRatingsCourses(RatingCursoModel ratingC){
        return this.rcRepository.save(ratingC);
    }

    public Mono<RatingCursoModel> findRatingsCourses(ObjectId id){
        return this.rcRepository.findById(id);
    }

    public Mono<Void> deleteRatingCourse(ObjectId id){
        return this.rcRepository.deleteById(id);
    }

    public Mono<Void> deleteAllRatingsCourses(){
        return this.rcRepository.deleteAll();
    }

     private final ReactiveMongoTemplate mongoTemplate;

    public RatingCursoService(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Flux<RatingCursoModel> findCoursesWithRatingsGreaterThan(double rating) {
        Criteria criteria = Criteria.where("ratings.calificacion").gt(rating);
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(criteria)
        );
        return mongoTemplate.aggregate(aggregation, "RatingsCursos", RatingCursoModel.class);
    }

}
