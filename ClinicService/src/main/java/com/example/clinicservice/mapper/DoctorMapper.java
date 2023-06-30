package com.example.clinicservice.mapper;

import com.example.clinicservice.dto.DoctorDto;
import com.example.clinicservice.model.DoctorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    DoctorEntity toEntity(DoctorDto doctorDto);

    DoctorDto toDto(DoctorEntity doctorEntity);

    @Mapping(target = "id", ignore = true)
    DoctorEntity mergeToEntity(DoctorDto doctorDto,
                               @MappingTarget DoctorEntity dogEntity);

    List<DoctorDto> toDtoList(List<DoctorEntity> doctorEnities);
}
