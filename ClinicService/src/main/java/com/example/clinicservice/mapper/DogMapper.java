package com.example.clinicservice.mapper;

import com.example.clinicservice.dto.DogDto;
import com.example.clinicservice.model.DogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DogMapper {

    @Mapping(target = "id", ignore = true)
    DogEntity toEntity(DogDto dogDto);

    DogDto toDto(DogEntity dogEntity);

    @Mapping(target = "id", ignore = true)
    DogEntity mergeToEntity(DogDto dogDto,
                            @MappingTarget DogEntity dogEntity);

    List<DogDto> toDtoList(List<DogEntity> dogEntities);
}
