package edu.uao.project.recomendationSystem.TutorCurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TutorCursoController {
    @Autowired
    private TutorCursoService tutorCService;

    @GetMapping("/allTutorsCourses")
    public ResponseEntity<Flux<TutorCursoModel>> allTutorsCourses(){
        Flux<TutorCursoModel> flux = this.tutorCService.allTutorsCourses();
        return new ResponseEntity<Flux<TutorCursoModel>>(flux, HttpStatus.OK);
    }

    @PostMapping("/addTutorsCourses")
    public ResponseEntity<Mono<TutorCursoModel>> addTutorsCourses(@RequestBody TutorCursoModel tutorC){
        Mono<TutorCursoModel> tcMono = this.tutorCService.addTutorsCourses(tutorC);
        return new ResponseEntity<Mono<TutorCursoModel>>(tcMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateTutorsCourses")
    public ResponseEntity<Mono<TutorCursoModel>> updateTutorsCourses(@RequestBody TutorCursoModel tutorC){
        Mono<TutorCursoModel> tcMono = this.tutorCService.updateTutorsCourses(tutorC);
        return new ResponseEntity<Mono<TutorCursoModel>>(tcMono, HttpStatus.CREATED);
    }

    @GetMapping("/findTutorsCourses/{id}")
    public ResponseEntity<Mono<TutorCursoModel>> findTutorsCourses(@PathVariable Integer id){
        Mono<TutorCursoModel> tcMono = this.tutorCService.findTutorsCourses(id);
        return new ResponseEntity<Mono<TutorCursoModel>>(tcMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTutorCourse/{id}")  
    public ResponseEntity<Mono<Void>> deleteTutorCourse(@PathVariable Integer id){
        Mono<Void> tcMono = this.tutorCService.deleteTutorCourse(id);
        return new ResponseEntity<Mono<Void>>(tcMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllTutorsCourses")
    public ResponseEntity<Mono<Void>> deleteAllTutorsCourses(){
        Mono<Void> tcMono = this.tutorCService.deleteAllTutorsCourses();
        return new ResponseEntity<Mono<Void>>(tcMono, HttpStatus.CREATED);
    }
}
