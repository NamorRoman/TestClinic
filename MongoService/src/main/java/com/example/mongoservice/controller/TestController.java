package com.example.mongoservice.controller;

import com.example.mongoservice.model.TestModel;
import com.example.mongoservice.repository.TestRepository;
import com.example.mongoservice.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    final TestService service;

    final TestRepository repository;

    @GetMapping("/index")
    public String getIndex() {
        return "INDEX";
    }

    @GetMapping("/")
    public List<TestModel> findAll() {
        return service.findAll();
    }

//    @PostMapping("/add")
//    public TestModel save(TestModel testModel) {
//        return service.insert(testModel);
//    }

    @PostMapping("/add")
    public TestModel save(TestModel testModel) {
        return repository.save(testModel);
    }
}
