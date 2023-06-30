package com.example.clinicservice.dto;

import com.example.clinicservice.model.CatEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * A DTO for the {@link CatEntity} entity
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cats")
public class CatDto implements Serializable {

    Long id;
    String name;
    String breed;
    Byte age;
    String sex;
    Boolean purrable;


}