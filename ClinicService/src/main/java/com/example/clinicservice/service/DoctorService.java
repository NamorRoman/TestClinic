package com.example.clinicservice.service;


import com.example.clinicservice.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> readAll();

    List<DoctorDto> readById(List<Long> ids);

    DoctorDto findById(Long id);

    DoctorDto save(DoctorDto dto);

    DoctorDto update(Long id, DoctorDto dto);


}
