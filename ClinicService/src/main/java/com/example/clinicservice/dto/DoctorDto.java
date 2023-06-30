package com.example.clinicservice.dto;

import com.example.clinicservice.model.DoctorEntity;
import com.example.clinicservice.model.SpecialityEntity;
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
 * A DTO for the {@link DoctorEntity} entity
 */

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorDto implements Serializable {

    Long id;
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    SpecialityEntity speciality;
}