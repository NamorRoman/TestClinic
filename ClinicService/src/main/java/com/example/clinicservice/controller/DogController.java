package com.example.clinicservice.controller;


import com.example.clinicservice.dto.DogDto;
import com.example.clinicservice.mapper.DogMapper;
import com.example.clinicservice.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dog")
public class DogController {

    private final DogService service;
    private final DogMapper mapper;


    @PostMapping("/add")
    public DogDto save(DogDto dogDto) {
        return service.save(dogDto);
    }


    @GetMapping("/all")
    public List<DogDto> readAll() {
        return service.readAll();
    }

}
