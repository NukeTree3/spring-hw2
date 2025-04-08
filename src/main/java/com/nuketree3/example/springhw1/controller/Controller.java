package com.nuketree3.example.springhw1.controller;

import com.nuketree3.example.springhw1.model.Student;
import com.nuketree3.example.springhw1.repositories.StudentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@Slf4j
public class Controller {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/student/{id}")
    @ResponseBody
    public Student student(@PathVariable int id) {
        log.info("student: " + id + "res:" + studentsRepository.getStudentById((long) id).toString());
        return studentsRepository.getStudentById((long) id);
    }

    @GetMapping("/student")
    @ResponseBody
    public List<Student> students() {
        log.info("students" + studentsRepository.getStudents().toString());
        return studentsRepository.getStudents();
    }

    @GetMapping("/student/{groupName}/student")
    @ResponseBody
    public List<Student> getStudentsByGroup(@PathVariable String groupName) {
        log.info("group name: " + groupName + " result " + studentsRepository.getAllStudentByGroupName(groupName).toString());
        return studentsRepository.getAllStudentByGroupName(groupName);
    }

    @PostMapping("/student")
    @ResponseBody
    public void addStudent(@RequestBody Student student) {
        log.info("student: " + student.toString());
        studentsRepository.addStudent(student);
    }
}
