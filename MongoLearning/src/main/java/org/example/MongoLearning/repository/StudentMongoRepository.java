package org.example.MongoLearning.repository;

import org.example.MongoLearning.po.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentMongoRepository extends MongoRepository<Student,String> {
}
