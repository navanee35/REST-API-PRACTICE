package com.navanee.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.navanee.demo.model.Student;
import com.navanee.demo.repository.StudentRepository;

import java.util.Set;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Set<Student> getAllStudents() {
        return new HashSet<>(studentRepository.findAll()); // ✅ Convert List to Set
    }
    //@Transactional
    public Set<Student> saveStudents(Set<Student> students) {
        return new HashSet<>(studentRepository.saveAll(students));
    }
   

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}