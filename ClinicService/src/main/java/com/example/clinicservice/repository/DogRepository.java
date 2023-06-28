package com.example.clinicservice.repository;

import com.example.clinicservice.model.DogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<DogEntity, Long> {
}