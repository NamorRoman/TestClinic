package com.example.paymentservice.mapper;

import com.example.paymentservice.dto.CardTransferDto;
import com.example.paymentservice.model.CardTransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardTransferMapper {

    @Mapping(target = "id", ignore = true)
    CardTransferEntity toEntity(CardTransferDto dto);

    CardTransferDto toDto(CardTransferEntity entity);

    @Mapping(target = "id", ignore = true)
    CardTransferEntity mergeToEntity(CardTransferDto dto,
                                     @MappingTarget CardTransferEntity entity);

    List<CardTransferDto> toDtoList(List<CardTransferEntity> entityList);

}
