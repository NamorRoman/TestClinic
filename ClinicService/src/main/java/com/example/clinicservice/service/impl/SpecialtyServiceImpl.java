package com.example.clinicservice.service.impl;

import com.example.clinicservice.dto.SpecialityDto;
import com.example.clinicservice.mapper.SpecialityMapper;
import com.example.clinicservice.repository.SpecialityRepository;
import com.example.clinicservice.service.SpecialtyService;
import com.example.clinicservice.service.common.EntityNotFoundReturner;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SpecialtyServiceImpl implements SpecialtyService {

    static String msg = "Не найдена специальность с ID ";

    SpecialityRepository repository;
    SpecialityMapper mapper;
    EntityNotFoundReturner notFoundReturner;


    @Override
    public List<SpecialityDto> readAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<SpecialityDto> readById(List<Long> ids) {
        final var resultList = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id)))
                .toList();

        return mapper.toDtoList(resultList);
    }

    @Override
    public SpecialityDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id)));
    }

    @Override
    public SpecialityDto save(SpecialityDto dto) {
        var res = repository.save(mapper.toEntity(dto));
        var resDto = mapper.toDto(res);
        log.info("Cat is added {}", resDto);
        return resDto;
    }

    @Override
    public SpecialityDto update(Long id, SpecialityDto dto) {

        final var targetEntity = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id));

        final var updateEntity = mapper.mergeToEntity(dto, targetEntity);

        return mapper.toDto(repository.save(updateEntity));
    }

}
