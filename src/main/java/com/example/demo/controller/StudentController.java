package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    ArrayList<Student> students =new ArrayList<>();
    @GetMapping("student")
    public List<Student> getname(){
        return students;
    }
//    @PostMapping("student")
//    public ResponseEntity ubdate(@RequestBody Student student){
////        if(student.getId()==null || student.getEmail()==null ||student.getName()==null){
////        return ResponseEntity.status(400).body("Not create ");}
////        student.
//    }
//
}
