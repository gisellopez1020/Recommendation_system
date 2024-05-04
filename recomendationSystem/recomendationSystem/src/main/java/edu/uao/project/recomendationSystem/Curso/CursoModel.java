package edu.uao.project.recomendationSystem.Curso;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="Cursos")
public class CursoModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String categoria;
    private Integer precio;
    private Integer horasTotales;
    private Integer idCurso;

}
