package edu.uao.project.recomendationSystem.Tutor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="Tutores")
public class TutorModel {
    @Id
    private ObjectId id;
    private String nombre;
    private String carrera;
    private Integer semestre;
    private Integer idTutor;
}
