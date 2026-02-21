package com.nitin.javaApplication.controller;

import com.nitin.javaApplication.entities.Student;
import com.nitin.javaApplication.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Home")
public class StudentInfo {

    Student student = new Student();

    @Autowired
    private StudentService studentService;

    @PostMapping
    public boolean addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return true;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.findStudent();
    }

    @GetMapping("/id/{myId}")
    public Student findStudentById(@PathVariable ObjectId myId){
        return studentService.findStudentById(myId);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteStudentById(@PathVariable ObjectId myId){
        studentService.deleteStudent(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public boolean updateStudentInfo(@PathVariable ObjectId myId ,@RequestBody Student student){
        studentService.updateStudentInfo(myId,student);
        return true;
    }

}
