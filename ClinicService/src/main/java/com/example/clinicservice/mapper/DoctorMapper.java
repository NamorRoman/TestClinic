package com.example.clinicservice.mapper;

import com.example.clinicservice.dto.DoctorDto;
import com.example.clinicservice.model.DoctorEnity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    DoctorEnity toEntity(DoctorDto doctorDto);

    DoctorDto toDto(DoctorEnity doctorEnity);

    @Mapping(target = "id", ignore = true)
    DoctorEnity mergeToEntity(DoctorDto doctorDto,
                            @MappingTarget DoctorEnity dogEntity);

    List<DoctorDto> toDtoList(List<DoctorEnity> doctorEnities);
}
