package edu.uao.project.recomendationSystem.Usuario;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Usuarios")

public class UsuarioModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String carrera;
    private Integer id_Usuario;

}
