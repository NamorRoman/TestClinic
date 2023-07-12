package com.example.mongoservice.service;

import com.example.mongoservice.model.TestModel;
import com.example.mongoservice.repository.TestRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class TestService {

   TestRepository repository;

    public TestModel save(TestModel testModel) {
        return repository.save(testModel);
    }

    public List<TestModel> findAll() {
        return repository.findAll();
    }
}
