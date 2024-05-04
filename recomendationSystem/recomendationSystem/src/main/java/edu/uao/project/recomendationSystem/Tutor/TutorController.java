package edu.uao.project.recomendationSystem.Tutor;

import org.bson.types.ObjectId;
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
public class TutorController {
    @Autowired
    private TutorService tutorService;

    @GetMapping("/allTutors")
    public ResponseEntity<Flux<TutorModel>> allTutors(){
        Flux<TutorModel> flux = this.tutorService.allTutors();
        return new ResponseEntity<Flux<TutorModel>>(flux, HttpStatus.OK);
    }

    @PostMapping("/addTutors")
    public ResponseEntity<Mono<TutorModel>> addTutors(@RequestBody TutorModel tutor){
        Mono<TutorModel> tutoresMono = this.tutorService.addTutors(tutor);
        return new ResponseEntity<Mono<TutorModel>>(tutoresMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateTutors")
    public ResponseEntity<Mono<TutorModel>> updateTutors(@RequestBody TutorModel tutor){
        Mono<TutorModel> tutoresMono = this.tutorService.updateTutors(tutor);
        return new ResponseEntity<Mono<TutorModel>>(tutoresMono, HttpStatus.CREATED);
    }

    @GetMapping("/findTutors/{id}")
    public ResponseEntity<Mono<TutorModel>> findTutors(@PathVariable ObjectId id){
        Mono<TutorModel> tutoresMono = this.tutorService.findTutors(id);
        return new ResponseEntity<Mono<TutorModel>>(tutoresMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTutor/{id}")  
    public ResponseEntity<Mono<Void>> deleteTutor(@PathVariable ObjectId id){
        Mono<Void> tutoresMono = this.tutorService.deleteTutor(id);
        return new ResponseEntity<Mono<Void>>(tutoresMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllTutors")
    public ResponseEntity<Mono<Void>> deleteAllTutors(){
        Mono<Void> tutoresMono = this.tutorService.deleteAllTutors();
        return new ResponseEntity<Mono<Void>>(tutoresMono, HttpStatus.CREATED);
    }
}
