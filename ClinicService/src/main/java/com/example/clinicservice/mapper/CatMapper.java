package com.example.clinicservice.mapper;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.model.CatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper для {@link CatEntity} и {@link CatDto}
 */
@Mapper(componentModel = "spring")
public interface CatMapper {

    @Mapping(target = "id", ignore = true)
    CatEntity toEntity(CatDto catDto);

    CatDto toDto(CatEntity catEntity);

    @Mapping(target = "id", ignore = true)
    CatEntity mergeToEntity(CatDto catDto,
                            @MappingTarget CatEntity catEntity);

    List<CatDto> toDtoList(List<CatEntity> catEntities);
}
