package com.example.clinicservice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SpecialityEntity {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "speciality", nullable = false)
    @OneToMany(mappedBy = "speciality")
    Set<DoctorEnity> doctors;

}
