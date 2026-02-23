package com.nitin.javaApplication.service;

import com.nitin.javaApplication.entities.Student;
import com.nitin.javaApplication.repos.StudentEnteryRepos;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService {

    @Autowired
    private StudentEnteryRepos studentEnteryRepos;

    public void addStudent(Student student){
        studentEnteryRepos.save(student);
    }

    public List<Student> findStudent(){
        return studentEnteryRepos.findAll();

    }

    public Student findStudentById(ObjectId myId){
        return studentEnteryRepos.findById(myId).orElse(null);
    }

    public void deleteStudent(ObjectId myId){
        studentEnteryRepos.deleteById(myId);
    }
}

