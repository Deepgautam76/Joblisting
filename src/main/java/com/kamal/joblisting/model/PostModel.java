package com.kamal.joblisting.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    @Id
    private ObjectId id;
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;
}

