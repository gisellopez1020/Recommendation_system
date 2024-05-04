package edu.uao.project.recomendationSystem.Rating;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Ratings")
public class RatingModel {
    @Id
    private ObjectId id;
    private Integer user_id;
    private float calificacion;
}
