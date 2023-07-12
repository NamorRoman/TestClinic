package com.example.clinicservice.mapper;


import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.model.CatEntity;
import com.example.clinicservice.supplier.CatSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatMapperTest {

    private static CatEntity entity;
    private static CatEntity additionalEntity;
    private static List<CatEntity> entityList;
    private static CatDto dto;
    private static CatDto additionalDto;
    private static List<CatDto> dtoList;

    private static CatSupplier supplier;

    private static CatMapper mapper;

    @BeforeEach
    void setup() {
        supplier = new CatSupplier();
        mapper = new CatMapperImpl();
        entity = supplier.getCatEntity(1L, "Cat", (byte) 5, "f");
        additionalEntity = supplier.getCatEntity(2L, "Tac", (byte) 10, "m");
        dto = supplier.getCatDto(1L, "Cat", (byte) 5, "f");
        additionalDto = supplier.getCatDto(2L, "Tac", (byte) 10, "m");
//        dtoList = supplier.getCatDtoList(dto, additionalDto);

    }

    @Test
    @DisplayName("конвартация в entity")
    void toEntityTest() {
        final CatEntity resultEntity = mapper.toEntity(dto);


        assertAll(
                () -> {
                    assertNull(resultEntity.getId());
                    assertEquals(dto.getName(), resultEntity.getName());
                    assertEquals(dto.getBreed(), resultEntity.getBreed());
                    assertEquals(dto.getAge(), resultEntity.getAge());
                    assertEquals(dto.getSex(), resultEntity.getSex());
                    assertEquals(dto.getPurrable(), resultEntity.getPurrable());
                }
        );
    }

    @Test
    @DisplayName("конвартация в dto")
    void toDtoTest() {
        final CatDto resultDto = mapper.toDto(entity);

        assertAll(
                () -> {
                    assertEquals(entity.getId(), resultDto.getId());
                    assertEquals(entity.getName(), resultDto.getName());
                    assertEquals(entity.getBreed(), resultDto.getBreed());
                    assertEquals(entity.getAge(), resultDto.getAge());
                    assertEquals(entity.getSex(), resultDto.getSex());
                    assertEquals(entity.getPurrable(), resultDto.getPurrable());
                }
        );
    }

    @Test
    @Disabled
    @DisplayName("конвертация в лист dto")
    void toDtoList() {

        List<CatDto> resultList = mapper.toDtoList(supplier.getEntityList(entity, additionalEntity));

        assertIterableEquals(supplier.getCatDtoList(dto, additionalDto), resultList);
    }
}
