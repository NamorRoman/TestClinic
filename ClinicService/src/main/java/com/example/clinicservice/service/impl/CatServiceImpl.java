package com.example.clinicservice.service.impl;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.mapper.CatMapper;
import com.example.clinicservice.repository.CatRepository;
import com.example.clinicservice.service.CatService;
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
public class CatServiceImpl implements CatService {

    static String msg = "Не найден кот с ID ";

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

        final var resultList = ids.stream()
                .map(id -> repository.findById(id)
                        .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id)))
                .toList();

        return mapper.toDtoList(resultList);
    }

    @Override
    public CatDto findById(Long id) {

        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id)));
    }

    @Override
    public CatDto save(CatDto dto) {
        var res = repository.save(mapper.toEntity(dto));
        var resDto = mapper.toDto(res);
        log.info("Cat is added {}", resDto);
        return resDto;
    }

    @Override
    public CatDto update(Long id, CatDto dto) {

        final var targetEntity = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id));

        final var updateEntity = mapper.mergeToEntity(dto, targetEntity);

        return mapper.toDto(repository.save(updateEntity));
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public CatDto findCatEntityByName(String name) {
        return mapper.toDto(repository.findCatEntityByName(name));
    }
}
