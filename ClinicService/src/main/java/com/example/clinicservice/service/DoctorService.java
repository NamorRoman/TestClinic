package com.example.clinicservice.service;


import com.example.clinicservice.dto.DoctorDto;
import com.example.clinicservice.model.DoctorEntity;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> readAll();

    List<DoctorDto> readById(List<Long> ids);

    DoctorDto findById(Long id);

    DoctorDto save(DoctorDto dto);

    DoctorDto update(Long id, DoctorDto dto);

    DoctorDto findDoctorEnitiesByFirstNameAndLastName(String firstName, String lastName);

//    List<DoctorDto> findDoctorEntitiesByCatPatients(Long catId);

}
