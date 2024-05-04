package edu.uao.project.recomendationSystem.Usuario;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveMongoRepository<UsuarioModel,ObjectId> {

    
}