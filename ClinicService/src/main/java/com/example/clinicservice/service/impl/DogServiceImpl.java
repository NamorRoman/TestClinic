package com.example.clinicservice.service.impl;

import com.example.clinicservice.dto.DogDto;
import com.example.clinicservice.mapper.DogMapper;
import com.example.clinicservice.repository.DogRepository;
import com.example.clinicservice.service.DogService;
import com.example.clinicservice.service.common.EntityNotFoundReturner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DogServiceImpl implements DogService {

    static final String msg = "Не найдена собака с ID ";
    private final DogRepository repository;
    private final DogMapper mapper;

    EntityNotFoundReturner notFoundReturner;

    @Override
    public List<DogDto> readAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<DogDto> readById(List<Long> ids) {
        return null;
    }

    @Override
    public DogDto findById(Long id) {
        return null;
    }

    @Override
    public DogDto save(DogDto dogDto) {
        var res = repository.save(mapper.toEntity(dogDto));
        var resDto = mapper.toDto(res);
        log.info("Dog is added {}", resDto);
        return resDto;
    }

    @Override
    public DogDto update(Long id, DogDto dto) {
        final var targetEntity = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id));

        return mapper.toDto(repository.save(mapper.mergeToEntity(dto, targetEntity)));
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
