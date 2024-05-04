package edu.uao.project.recomendationSystem.RatingCurso;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.uao.project.recomendationSystem.Rating.RatingModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "RatingsCursos")
public class RatingCursoModel {
    @Id
    private ObjectId id;
    private String name;
    private List<RatingModel> ratings;

    private Integer courseId;

}
