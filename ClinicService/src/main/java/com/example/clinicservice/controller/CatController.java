package com.example.clinicservice.controller;

import com.example.clinicservice.dto.CatDto;
import com.example.clinicservice.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/cat")
public class CatController {

    private final CatService service;

    @GetMapping("/all")
    public List<CatDto> readAll() {
        return service.readAll();
    }

    @PostMapping("/add")
    public CatDto save(CatDto dto) {
        return service.save(dto);
    }

}
