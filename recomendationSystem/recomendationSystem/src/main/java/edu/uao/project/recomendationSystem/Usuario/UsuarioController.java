package edu.uao.project.recomendationSystem.Usuario;

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

public class UsuarioController {
    @Autowired
    private UsuarioService userService;

    @GetMapping("/allUsers")
    public ResponseEntity<Flux<UsuarioModel>> allUsers(){
        Flux<UsuarioModel> flux = this.userService.allUsers();
        return new ResponseEntity<Flux<UsuarioModel>>(flux, HttpStatus.OK);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<Mono<UsuarioModel>> addUsers(@RequestBody UsuarioModel usuario){
        Mono<UsuarioModel> usuariosMono = this.userService.addUsers(usuario);
        return new ResponseEntity<Mono<UsuarioModel>>(usuariosMono, HttpStatus.CREATED);
    }

    @PutMapping("/updateUsers")
    public ResponseEntity<Mono<UsuarioModel>> updateUsers(@RequestBody UsuarioModel usuario){
        Mono<UsuarioModel> usuariosMono = this.userService.updateUsers(usuario);
        return new ResponseEntity<Mono<UsuarioModel>>(usuariosMono, HttpStatus.CREATED);
    }

    @GetMapping("/findUsers/{id}")
    public ResponseEntity<Mono<UsuarioModel>> findUsers(@PathVariable ObjectId id){
        Mono<UsuarioModel> usuariosMono = this.userService.findUsers(id);
        return new ResponseEntity<Mono<UsuarioModel>>(usuariosMono, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")  
    public ResponseEntity<Mono<Void>> deleteUser(@PathVariable ObjectId id){
        Mono<Void> usuariosMono = this.userService.deleteUser(id);
        return new ResponseEntity<Mono<Void>>(usuariosMono, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<Mono<Void>> deleteAllUsers(){
        Mono<Void> usuariosMono = this.userService.deleteAllUsers();
        return new ResponseEntity<Mono<Void>>(usuariosMono, HttpStatus.CREATED);
    }
}
