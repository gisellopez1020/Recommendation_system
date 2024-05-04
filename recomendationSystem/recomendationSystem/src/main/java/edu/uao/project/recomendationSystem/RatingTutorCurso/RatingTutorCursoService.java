package edu.uao.project.recomendationSystem.RatingTutorCurso;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RatingTutorCursoService {
    @Autowired
    private RatingTutorCursoRepository rtcRepository;

    public Flux<RatingTutorCursoModel> allRatingsTutorsCourses(){
        return this.rtcRepository.findAll();
    }

    public Mono<RatingTutorCursoModel> addRatingsTutorsCourses(RatingTutorCursoModel ratingTC){
        return this.rtcRepository.save(ratingTC);
    }

    public Mono<RatingTutorCursoModel> updateRatingsTutorsCourses(RatingTutorCursoModel ratingTC){
        return this.rtcRepository.save(ratingTC);
    }

    public Mono<RatingTutorCursoModel> findRatingsTutorsCourses(ObjectId id){
        return this.rtcRepository.findById(id);
    }

    public Mono<Void> deleteRatingTutorCourse(ObjectId id){
        return this.rtcRepository.deleteById(id);
    }

    public Mono<Void> deleteAllRatingsTutorsCourses(){
        return this.rtcRepository.deleteAll();
    }
}
