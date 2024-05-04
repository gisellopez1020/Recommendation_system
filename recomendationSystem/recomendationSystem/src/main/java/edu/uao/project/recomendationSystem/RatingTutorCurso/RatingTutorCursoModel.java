package edu.uao.project.recomendationSystem.RatingTutorCurso;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import edu.uao.project.recomendationSystem.Rating.RatingModel;
import edu.uao.project.recomendationSystem.TutorCurso.TutorCursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "RatingsTutoresCursos")
public class RatingTutorCursoModel {
    @Id
    private ObjectId id;

    @Field("idTutorCurso")
    private Integer idTutorCurso;

    @DBRef
    private TutorCursoModel tutorCurso;

    private List<RatingModel> ratings;
}
