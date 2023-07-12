package com.example.clinicservice.repository;

import com.example.clinicservice.model.CatEntity;
import com.example.clinicservice.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

    DoctorEntity findDoctorEnitiesByFirstNameAndLastName(String firstName, String lastName);




}