package com.example.clinicservice.service;


import com.example.clinicservice.dto.SpecialityDto;

import java.util.List;

public interface SpecialtyService {

    List<SpecialityDto> readAll();

    List<SpecialityDto> readById(List<Long> ids);

    SpecialityDto findById(Long id);

    SpecialityDto save(SpecialityDto dto);

    SpecialityDto update(Long id, SpecialityDto dto);

}
