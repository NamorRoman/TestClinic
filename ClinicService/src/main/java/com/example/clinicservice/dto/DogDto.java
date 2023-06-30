package com.example.clinicservice.dto;

import com.example.clinicservice.model.DogEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link DogEntity} entity
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DogDto implements Serializable {

    Long id;
    String name;
    String breed;
    Byte age;
    String sex;
    @NotNull
    String woolType;
    Boolean aggressiveness;

    @Override
    public String toString() {
        return "DogDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", woolType='" + woolType + '\'' +
                ", aggressiveness=" + aggressiveness +
                '}';
    }
}