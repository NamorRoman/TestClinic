package com.example.clinicservice.dto;

import com.example.clinicservice.model.DoctorEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link DoctorEntity} entity
 */
@Data
public class DoctorDto implements Serializable {
    private final Long id;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    private final SpecialityDto speciality;
    private final Collection<CatDto> catPatients;
}