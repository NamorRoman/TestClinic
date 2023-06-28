package com.example.clinicservice.supplier;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.model.CatEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatSupplier implements AbstractSupplier {

    public CatEntity getCatEntity(Long id, String name, Byte age, String sex) {
        return new CatEntity(id, name, breed, age, sex, purrable);
    }

    public CatDto getCatDto(Long id, String name, Byte age, String sex) {
        return new CatDto(id, name, breed, age, sex, purrable);
    }

    public List<CatDto> getCatDtoList(CatDto... dtos) {
        return List.of(dtos);
    }

    public List<CatEntity> getEntityList(CatEntity... entities) {
        return List.of(entities);
    }

}
