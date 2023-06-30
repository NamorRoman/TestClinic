package com.example.clinicservice.controller;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.dto.DoctorDto;
import com.example.clinicservice.service.CatService;
import com.example.clinicservice.service.DoctorService;
import com.example.clinicservice.service.impl.DoctorServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;
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

    private final DoctorService service;

    @GetMapping("/all")
    public List<DoctorDto> readAll() {
        return service.readAll();
    }

    @PostMapping("/add")
    public DoctorDto save(DoctorDto dto) {
        return service.save(dto);
    }
}
