package com.example.clinicservice.service.impl;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.mapper.CatMapper;
import com.example.clinicservice.model.CatEntity;
import com.example.clinicservice.repository.CatRepository;
import com.example.clinicservice.service.CatService;
import com.example.clinicservice.service.common.EntityNotFoundReturner;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatServiceImpl implements CatService {

    static String message = "Не найден кот с ID ";

    CatRepository repository;
    CatMapper mapper;
    EntityNotFoundReturner notFoundReturner;


    @Override
    @Transactional
    public List<CatDto> readAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<CatDto> readById(List<Long> ids) {

        final List<CatEntity> catEntities = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(message, id)))
                .toList();

        return mapper.toDtoList(catEntities);
    }

    @Override
    public CatDto findById(Long id) {

        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(message, id)));
    }

    @Override
    public CatDto save(CatDto dto) {
        CatEntity catEntity = repository.save(mapper.toEntity(dto));

        return mapper.toDto(catEntity);
    }


    @Override
    public CatDto update(Long id, CatDto dto) {

        final CatEntity targetEntity = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(message, id));

        final CatEntity updateEntity = mapper.mergeToEntity(dto, targetEntity);

        return mapper.toDto(repository.save(updateEntity));

    }

    @Override
    public Long count() {
        return repository.count();
    }
}
