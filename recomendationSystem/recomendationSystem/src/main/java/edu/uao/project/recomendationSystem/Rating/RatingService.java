package edu.uao.project.recomendationSystem.Rating;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RatingService {
    @Autowired
    private RatingRepository rRepository;

    public Flux<RatingModel> allRatings(){
        return this.rRepository.findAll();
    }

    public Mono<RatingModel> addRatings(RatingModel rating){
        return this.rRepository.save(rating);
    }

    public Mono<RatingModel> updateRatings(RatingModel rating){
        return this.rRepository.save(rating);
    }

    public Mono<RatingModel> findRatings(ObjectId id){
        return this.rRepository.findById(id);
    }

    public Mono<Void> deleteRating(ObjectId id){
        return this.rRepository.deleteById(id);
    }

    public Mono<Void> deleteAllRatings(){
        return this.rRepository.deleteAll();
    }
}
