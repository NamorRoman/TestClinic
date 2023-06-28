package com.example.clinicservice.model;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorEnity {

    @Id
    @Column(name = "id")
    Long id;


    @Column(name = "first_name")
    @NotNull
    String firstName;

    @Column(name = "last_name")
    @NotNull
    String lastName;

    @ManyToOne()
    @JoinColumn(name = "speciality_id")
    SpecialityEntity speciality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEnity doctor = (DoctorEnity) o;
        return Objects.equals(id, doctor.id)
                && Objects.equals(firstName, doctor.firstName)
                && Objects.equals(lastName, doctor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
