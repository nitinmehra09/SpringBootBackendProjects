package com.nitin.javaApplication.controller;

import com.nitin.javaApplication.entities.Student;
import com.nitin.javaApplication.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.findStudent();
        if(!students.isEmpty()){
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> findStudentById(@PathVariable ObjectId myId){
        Student student = studentService.findStudentById(myId);
        if(student!=null){
            return new ResponseEntity<>(student,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteStudentById(@PathVariable ObjectId myId){
        studentService.deleteStudent(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateStudentInfo(@PathVariable ObjectId myId ,@RequestBody Student newStudent){
        Student oldStudent = studentService.findStudentById(myId);
        if (oldStudent != null) {
            if (newStudent.getName() != null && !newStudent.getName().isEmpty()) {
                oldStudent.setName(newStudent.getName());
            }
            if (newStudent.getAge() != 0) {
                oldStudent.setAge(newStudent.getAge());
            }
            studentService.addStudent(oldStudent);
            return new ResponseEntity<>(oldStudent,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
