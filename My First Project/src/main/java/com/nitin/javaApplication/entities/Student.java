package com.nitin.javaApplication.entities;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@Document
public class Student {
    @Id
    private ObjectId studentId;
    private String name;
    private int age;

}
