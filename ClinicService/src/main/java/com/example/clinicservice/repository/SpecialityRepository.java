package com.example.clinicservice.repository;

import com.example.clinicservice.model.SpecialityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<SpecialityEntity, Long> {
}