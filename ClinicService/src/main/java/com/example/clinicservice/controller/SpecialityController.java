package com.example.clinicservice.controller;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.dto.SpecialityDto;
import com.example.clinicservice.service.SpecialtyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/speciality")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpecialityController {

    SpecialtyService service;

    @GetMapping("/all")
    public List<SpecialityDto> readAll() {
        return service.readAll();
    }
//
//    @GetMapping("/count")
//    public Long getCount() {
//        return service.count();
//    }

    @PostMapping("/add")
    public SpecialityDto save(SpecialityDto dto) {
        return service.save(dto);
    }

}
