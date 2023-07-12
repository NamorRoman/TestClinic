package com.example.mongoservice.model;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class TestModel {

    @Id
    String id;
    String name;
    Integer value;

    Integer extraField;

    public TestModel(String name, Integer value, Integer extraField) {
        this.name = name;
        this.value = value;
        this.extraField = extraField;
    }
}
