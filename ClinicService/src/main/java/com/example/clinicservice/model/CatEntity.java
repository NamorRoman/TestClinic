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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cats")

public class CatEntity {

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

    @Column(name = "purrable")
    Boolean purrable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatEntity catEntity = (CatEntity) o;
        return Objects.equals(id, catEntity.id)
                && Objects.equals(name, catEntity.name)
                && Objects.equals(breed, catEntity.breed)
                && Objects.equals(age, catEntity.age)
                && Objects.equals(sex, catEntity.sex)
                && Objects.equals(purrable, catEntity.purrable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, age, sex, purrable);
    }
}
