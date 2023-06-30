package com.example.clinicservice.controller;


import com.example.clinicservice.dto.DogDto;
import com.example.clinicservice.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dog")
public class DogController {

    private final DogService service;

    @GetMapping("/all")
    public List<DogDto> readAll() {
        return service.readAll();
    }

    @GetMapping("/count")
    public Long getCount() {
        return service.count();
    }

    @PostMapping("/add")
    public DogDto save(DogDto dogDto) {
        return service.save(dogDto);
    }

    @PatchMapping("/{id}")
    public DogDto updateDog(@PathVariable("id") Long id, DogDto dto) {
        return service.update(id, dto);
    }


}
