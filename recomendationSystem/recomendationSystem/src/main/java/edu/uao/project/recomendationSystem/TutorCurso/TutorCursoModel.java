package edu.uao.project.recomendationSystem.TutorCurso;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "TutoresCursos")
public class TutorCursoModel {
    @Id
    private ObjectId idTutorCurso;
    private String nombre;
    private String cursos[];

}
