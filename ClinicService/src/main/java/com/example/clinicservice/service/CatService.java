package com.example.clinicservice.service;


import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.model.CatEntity;

import java.util.List;


public interface CatService {

    List<CatDto> readAll();

    List<CatDto> readById(List<Long> ids);

    CatDto findById(Long id);

    CatDto save(CatDto dto);

    CatDto update(Long id, CatDto dto);

    Long count();

    CatDto findCatEntityByName(String name);

}
