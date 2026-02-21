package com.nitin.javaApplication.repos;

import com.nitin.javaApplication.entities.Student;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface StudentEnteryRepos extends MongoRepository<Student, ObjectId> {

}
