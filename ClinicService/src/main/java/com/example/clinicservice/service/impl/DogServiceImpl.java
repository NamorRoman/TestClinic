package com.example.clinicservice.service.impl;

import com.example.clinicservice.dto.DogDto;
import com.example.clinicservice.mapper.DogMapper;
import com.example.clinicservice.repository.DogRepository;
import com.example.clinicservice.service.DogService;
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

    private final DogRepository repository;
    private final DogMapper mapper;


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
        repository.save(mapper.toEntity(dogDto));
        log.info("Dog is added {}", dogDto.toString());
        return dogDto;
    }

    @Override
    public DogDto update(Long id, DogDto dto) {
        return null;
    }

    @Override
    public Long count() {
        return repository.count();
    }
}
