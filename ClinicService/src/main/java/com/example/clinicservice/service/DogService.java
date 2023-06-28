package com.example.clinicservice.service;


import com.example.clinicservice.dto.DogDto;

import java.util.List;

public interface DogService {

    List<DogDto> readAll();

    List<DogDto> readById(List<Long> ids);

    DogDto findById(Long id);

    DogDto save(DogDto dto);

    DogDto update(Long id, DogDto dto);

}

