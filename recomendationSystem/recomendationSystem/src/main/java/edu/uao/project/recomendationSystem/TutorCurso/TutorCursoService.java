package edu.uao.project.recomendationSystem.TutorCurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorCursoService {
    @Autowired
    private TutorCursoRepository tcRepository;

    public Flux<TutorCursoModel> allTutorsCourses(){
        return this.tcRepository.findAll();
    }

    public Mono<TutorCursoModel> addTutorsCourses(TutorCursoModel tutorCurso){
        return this.tcRepository.save(tutorCurso);
    }

    public Mono<TutorCursoModel> updateTutorsCourses(TutorCursoModel tutorCurso){
        return this.tcRepository.save(tutorCurso);
    }

    public Mono<TutorCursoModel> findTutorsCourses(Integer id){
        return this.tcRepository.findById(id);
    }

    public Mono<Void> deleteTutorCourse(Integer id){
        return this.tcRepository.deleteById(id);
    }

    public Mono<Void> deleteAllTutorsCourses(){
        return this.tcRepository.deleteAll();
    }
}
