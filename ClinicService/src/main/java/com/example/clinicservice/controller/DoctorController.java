package com.example.clinicservice.controller;

import com.example.clinicservice.dto.DoctorDto;
import com.example.clinicservice.dto.SpecialityDto;
import com.example.clinicservice.service.CatService;
import com.example.clinicservice.service.DoctorService;
import com.example.clinicservice.service.SpecialtyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {

    private final DoctorService doctorService;
    private final SpecialtyService specialtyService;
    private final CatService catService;

    @GetMapping("/all")
    public List<DoctorDto> readAll() {
        return doctorService.readAll();
    }

    @PostMapping("/add")
    public DoctorDto save(DoctorDto dto) {
        SpecialityDto speciality = specialtyService.findOrCreate(dto.getSpeciality().getSpecialityName());
        //TODO Set speciality to new dto and save res to db
        return doctorService.save(dto);
    }


    @GetMapping("/{id}/cat_patients/")
    public List<DoctorDto> readAllCatPatients(@PathVariable("id") Long id) {
        return catService.findDoctorsByCatId(id);
    }
}
