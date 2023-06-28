package com.example.clinicservice.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "dogs")
public class DogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "breed")
    String breed;

    @Column(name = "age")
    Byte age;

    @Column(name = "sex", nullable = false)
    String sex;

    @Column(name = "wool_type")
    @NotNull
    String woolType;

    @Column(name = "aggressiveness")
    Boolean aggressiveness;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogEntity dog = (DogEntity) o;
        return Objects.equals(id, dog.id)
                && Objects.equals(woolType, dog.woolType)
                && Objects.equals(aggressiveness, dog.aggressiveness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, woolType, aggressiveness);
    }
}
