package edu.uao.project.recomendationSystem.Rating;

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
public class RatingController {
    @Autowired
    private RatingService rService;

    @GetMapping("/allRatings")
    public ResponseEntity<Flux<RatingModel>> allRatings(){
        Flux<RatingModel> flux = this.rService.allRatings();
        return new ResponseEntity<Flux<RatingModel>>(flux, HttpStatus.OK);
    }

    @PostMapping("/addRatings")
    public ResponseEntity<Mono<RatingModel>> addRatings(@RequestBody RatingModel rating){
        Mono<RatingModel> rMono = this.rService.addRatings(rating);
        return new ResponseEntity<Mono<RatingModel>>(rMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateRatings")
    public ResponseEntity<Mono<RatingModel>> updateRatings(@RequestBody RatingModel rating){
        Mono<RatingModel> rMono = this.rService.updateRatings(rating);
        return new ResponseEntity<Mono<RatingModel>>(rMono, HttpStatus.CREATED);
    }

    @GetMapping("/findRatings/{id}")
    public ResponseEntity<Mono<RatingModel>> findRatings(@PathVariable ObjectId id){
        Mono<RatingModel> rMono = this.rService.findRatings(id);
        return new ResponseEntity<Mono<RatingModel>>(rMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRating/{id}")  
    public ResponseEntity<Mono<Void>> deleteRating(@PathVariable ObjectId id){
        Mono<Void> rMono = this.rService.deleteRating(id);
        return new ResponseEntity<Mono<Void>>(rMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllRatings")
    public ResponseEntity<Mono<Void>> deleteAllRatings(){
        Mono<Void> rMono = this.rService.deleteAllRatings();
        return new ResponseEntity<Mono<Void>>(rMono, HttpStatus.CREATED);
    }
}
