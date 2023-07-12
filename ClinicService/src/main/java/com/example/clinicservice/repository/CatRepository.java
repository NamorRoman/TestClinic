package com.example.clinicservice.repository;

import com.example.clinicservice.model.CatEntity;
import com.example.clinicservice.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CatRepository extends JpaRepository<CatEntity, Long> {
    CatEntity findCatEntityByName(String name);

//    List<CatEntity> findCatEntitiesByDoctors(Long doctorId);

    @Query("SELECT c.doctors FROM CatEntity c WHERE c.id = :id")
    List<DoctorEntity> findDoctorsByCatId(@Param("id") Long id);
}