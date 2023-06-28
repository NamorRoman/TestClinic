package com.example.clinicservice.repository;

import com.example.clinicservice.model.DoctorEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEnity, Long> {
}