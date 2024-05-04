package edu.uao.project.recomendationSystem.Curso;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Flux<CursoModel> allCourses(){
        return cursoRepository.findAll();
    }

    public Mono<CursoModel> addCourses(CursoModel curso){
        return cursoRepository.save(curso);
    }

    public Mono<CursoModel> updateCourses(CursoModel curso){
        return cursoRepository.save(curso);
    }

    public Mono<CursoModel> findCourses(ObjectId id){
        return cursoRepository.findById(id);
    }

    public Mono<Void> deleteCourse(ObjectId id){
        return cursoRepository.deleteById(id);
    }

    public Mono<Void> deleteAllCourses(){
        return cursoRepository.deleteAll();
    }


}


