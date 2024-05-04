package edu.uao.project.recomendationSystem.Curso;

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
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService courseService;

    @GetMapping("/allCourses")
    public ResponseEntity<Flux<CursoModel>> listarCursos(){
        Flux<CursoModel> cursos = courseService.allCourses();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @PostMapping("/addCourses")
    public ResponseEntity<Mono<CursoModel>> addCourses(@RequestBody CursoModel curso){
        Mono<CursoModel> cursosMono = this.courseService.addCourses(curso);
        return new ResponseEntity<Mono<CursoModel>>(cursosMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateCourses")
    public ResponseEntity<Mono<CursoModel>> updateCourses(@RequestBody CursoModel curso){
        Mono<CursoModel> cursosMono = this.courseService.updateCourses(curso);
        return new ResponseEntity<Mono<CursoModel>>(cursosMono, HttpStatus.CREATED);
    }

    @GetMapping("/findCourses/{idCurso}")
    public ResponseEntity<Mono<CursoModel>> findCourses(@PathVariable("idCurso") ObjectId idCurso){
        Mono<CursoModel> cursosMono = this.courseService.findCourses(idCurso);
        return new ResponseEntity<Mono<CursoModel>>(cursosMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourse/{idCurso}")  
    public ResponseEntity<Mono<Void>> deleteCourse(@PathVariable("idCurso") ObjectId idCurso){
        Mono<Void> cursosMono = this.courseService.deleteCourse(idCurso);
        return new ResponseEntity<Mono<Void>>(cursosMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllCourses")
    public ResponseEntity<Mono<Void>> deleteAllCourses(){
        Mono<Void> cursosMono = this.courseService.deleteAllCourses();
        return new ResponseEntity<Mono<Void>>(cursosMono, HttpStatus.CREATED);
    }

}
