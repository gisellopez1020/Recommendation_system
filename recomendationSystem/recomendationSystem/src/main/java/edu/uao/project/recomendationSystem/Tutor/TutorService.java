package edu.uao.project.recomendationSystem.Tutor;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tRepository;

    public Flux<TutorModel> allTutors(){
        return this.tRepository.findAll();
    }

    public Mono<TutorModel> addTutors(TutorModel tutor){
        return this.tRepository.save(tutor);
    }

    public Mono<TutorModel> updateTutors(TutorModel tutor){
        return this.tRepository.save(tutor);
    }

    public Mono<TutorModel> findTutors(ObjectId id){
        return this.tRepository.findById(id);
    }

    public Mono<Void> deleteTutor(ObjectId id){
        return this.tRepository.deleteById(id);
    }

    public Mono<Void> deleteAllTutors(){
        return this.tRepository.deleteAll();
    }
}
