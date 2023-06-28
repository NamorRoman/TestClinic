package com.example.clinicservice.mapper;

import com.example.clinicservice.dto.DogDto;
import com.example.clinicservice.dto.SpecialityDto;
import com.example.clinicservice.model.SpecialityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {

    @Mapping(target = "id", ignore = true)
    SpecialityEntity toEntity(SpecialityDto specialityDto);

    SpecialityDto toDto(SpecialityEntity specialityEntity);

    @Mapping(target = "id", ignore = true)
    SpecialityEntity mergeToEntity(SpecialityDto specialityDto,
                                   @MappingTarget SpecialityEntity specialityEntity);

    List<SpecialityDto> toDtoList(List<SpecialityEntity> specialityEntities);
}
