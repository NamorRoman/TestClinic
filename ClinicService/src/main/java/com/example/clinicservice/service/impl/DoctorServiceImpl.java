package com.example.clinicservice.service.impl;

import com.example.clinicservice.dto.DoctorDto;
import com.example.clinicservice.mapper.DoctorMapper;
import com.example.clinicservice.model.CatEntity;
import com.example.clinicservice.model.DoctorEntity;
import com.example.clinicservice.model.SpecialityEntity;
import com.example.clinicservice.repository.CatRepository;
import com.example.clinicservice.repository.DoctorRepository;
import com.example.clinicservice.repository.SpecialityRepository;
import com.example.clinicservice.service.DoctorService;
import com.example.clinicservice.service.common.EntityNotFoundReturner;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DoctorServiceImpl implements DoctorService {

    static String msg = "Не найден доктор с ID ";

    DoctorRepository repository;
    SpecialityRepository specialityRepository;
    CatRepository catRepository;

    DoctorMapper mapper;

    EntityNotFoundReturner notFoundReturner;

    @Override
    public List<DoctorDto> readAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<DoctorDto> readById(List<Long> ids) {
        List<DoctorEntity> resList = ids.stream().map(id -> repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id))).toList();

        return mapper.toDtoList(resList);
    }

    @Override
    public DoctorDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id)));
    }

    @Override
    public DoctorDto save(DoctorDto dto) {

//        TODO check isPresent
//        SpecialityEntity spec = specialityRepository
//                .findById(dto.getSpeciality().getId()).orElseThrow();


//        Optional<SpecialityEntity> spec = specialityRepository.findById(dto.getSpecialityID());

//        List<CatEntity> catPatients = dto.getCatPatients()
//                .stream().map(x -> catRepository.findById(x.getId()))
//                .filter(Optional::isPresent).map(Optional::get).toList();

//        DoctorEntity newDoctor = mapper.toEntity(dto);
//        newDoctor.setSpeciality(spec);
//        newDoctor.setCatPatients(catPatients);

        var res = repository.save(mapper.toEntity(dto));
//        var res = repository.save(mapper.toEntity(dto));

        var resDto = mapper.toDto(res);
        log.info("Doctor is added {}", resDto);
        return resDto;
    }

    @Override
    public DoctorDto update(Long id, DoctorDto dto) {
        final var targetEntity = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id));

        return mapper.toDto(repository.save(mapper.mergeToEntity(dto, targetEntity)));
    }

    @Override
    public DoctorDto findDoctorEnitiesByFirstNameAndLastName(String firstName, String lastName) {
        return mapper.toDto(repository.findDoctorEnitiesByFirstNameAndLastName(firstName, lastName));
    }
}
