package edu.uao.project.recomendationSystem.RatingTutorCurso;

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
public class RatingTutorCursoController {
    @Autowired
    private RatingTutorCursoService rtcService;

    @GetMapping("/allRatingsTutorsCourses")
    public ResponseEntity<Flux<RatingTutorCursoModel>> allRatingsTutorsCourses(){
        Flux<RatingTutorCursoModel> flux = this.rtcService.allRatingsTutorsCourses();
        return new ResponseEntity<Flux<RatingTutorCursoModel>>(flux, HttpStatus.OK);
    }

    @PostMapping("/addRatingsTutorsCourses")
    public ResponseEntity<Mono<RatingTutorCursoModel>> addRatingsTutorsCourses(@RequestBody RatingTutorCursoModel rating){
        Mono<RatingTutorCursoModel> rtcMono = this.rtcService.addRatingsTutorsCourses(rating);
        return new ResponseEntity<Mono<RatingTutorCursoModel>>(rtcMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateRatingsTutorsCourses")
    public ResponseEntity<Mono<RatingTutorCursoModel>> updateRatingsTutorsCourses(@RequestBody RatingTutorCursoModel rating){
        Mono<RatingTutorCursoModel> rtcMono = this.rtcService.updateRatingsTutorsCourses(rating);
        return new ResponseEntity<Mono<RatingTutorCursoModel>>(rtcMono, HttpStatus.CREATED);
    }

    @GetMapping("/findRatingsTutorsCourses/{id}")
    public ResponseEntity<Mono<RatingTutorCursoModel>> findRatingsTutorsCourses(@PathVariable ObjectId id){
        Mono<RatingTutorCursoModel> rtcMono = this.rtcService.findRatingsTutorsCourses(id);
        return new ResponseEntity<Mono<RatingTutorCursoModel>>(rtcMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRatingTutorCourse/{id}")  
    public ResponseEntity<Mono<Void>> deleteRatingTutorCourse(@PathVariable ObjectId id){
        Mono<Void> rtcMono = this.rtcService.deleteRatingTutorCourse(id);
        return new ResponseEntity<Mono<Void>>(rtcMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllRatingsTutorsCourses")
    public ResponseEntity<Mono<Void>> deleteAllRatingsTutorsCourses(){
        Mono<Void> rtcMono = this.rtcService.deleteAllRatingsTutorsCourses();
        return new ResponseEntity<Mono<Void>>(rtcMono, HttpStatus.CREATED);
    }
}
