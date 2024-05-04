package edu.uao.project.recomendationSystem.Usuario;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Flux<UsuarioModel> allUsers(){
        return this.repository.findAll();
    }

    public Mono<UsuarioModel> addUsers(UsuarioModel usuario){
        return this.repository.save(usuario);
    }

    public Mono<UsuarioModel> updateUsers(UsuarioModel usuario){
        return this.repository.save(usuario);
    }

    public Mono<UsuarioModel> findUsers(ObjectId id){
        return this.repository.findById(id);
    }

    public Mono<Void> deleteUser(ObjectId id){
        return this.repository.deleteById(id);
    }

    public Mono<Void> deleteAllUsers(){
        return this.repository.deleteAll();
    }
}
