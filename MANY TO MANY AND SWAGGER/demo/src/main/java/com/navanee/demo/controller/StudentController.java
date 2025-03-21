package com.navanee.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.navanee.demo.model.Student;
import com.navanee.demo.service.StudentService;

import java.util.Set;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public Set<Student> getAllStudents() {
        return studentService.getAllStudents(); // ✅ Return Set instead of List
    }

    @PostMapping
    public Set<Student> saveStudents(@RequestBody Set<Student> students) {
        return studentService.saveStudents(students);
    }
   
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}