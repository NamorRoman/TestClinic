package com.example.mongoservice.repository;

import com.example.mongoservice.model.TestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TestRepository extends MongoRepository<TestModel, String> {

    List<TestModel> findAllByValue(Integer value);
}
