package edu.uao.project.recomendationSystem.RatingCurso;

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
@RequestMapping("/api/rating")
public class RatingCursoController {
    @Autowired
    private RatingCursoService rcService;

    @GetMapping("/allRatingsCourses")
    public ResponseEntity<Flux<RatingCursoModel>> allRatingsCourses(){
        Flux<RatingCursoModel> flux = this.rcService.allRatingsCourses();
        return new ResponseEntity<Flux<RatingCursoModel>>(flux, HttpStatus.OK);
    }

    @PostMapping("/addRatingsCourses")
    public ResponseEntity<Mono<RatingCursoModel>> addRatingsCourses(@RequestBody RatingCursoModel rating){
        Mono<RatingCursoModel> rcMono = this.rcService.addRatingsCourses(rating);
        return new ResponseEntity<Mono<RatingCursoModel>>(rcMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateRatingsCourses")
    public ResponseEntity<Mono<RatingCursoModel>> updateRatingsCourses(@RequestBody RatingCursoModel rating){
        Mono<RatingCursoModel> rcMono = this.rcService.updateRatingsCourses(rating);
        return new ResponseEntity<Mono<RatingCursoModel>>(rcMono, HttpStatus.CREATED);
    }

    @GetMapping("/findRatingsCourses/{id}")
    public ResponseEntity<Mono<RatingCursoModel>> findRatingsCourses(@PathVariable ObjectId id){
        Mono<RatingCursoModel> rcMono = this.rcService.findRatingsCourses(id);
        return new ResponseEntity<Mono<RatingCursoModel>>(rcMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRatingCourse/{id}")  
    public ResponseEntity<Mono<Void>> deleteRatingCourse(@PathVariable ObjectId id){
        Mono<Void> rcMono = this.rcService.deleteRatingCourse(id);
        return new ResponseEntity<Mono<Void>>(rcMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllRatingsCourses")
    public ResponseEntity<Mono<Void>> deleteAllRatingsCourses(){
        Mono<Void> rcMono = this.rcService.deleteAllRatingsCourses();
        return new ResponseEntity<Mono<Void>>(rcMono, HttpStatus.CREATED);
    }

    @GetMapping("/ratingGreaterThan/{rating}")
    public ResponseEntity<Flux<RatingCursoModel>> getRatingsWithRatingGreaterThan(@PathVariable("rating") double rating){
        Flux<RatingCursoModel> ratings = rcService.findCoursesWithRatingsGreaterThan(rating);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
