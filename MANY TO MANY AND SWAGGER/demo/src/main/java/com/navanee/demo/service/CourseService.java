package com.navanee.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.navanee.demo.model.Course;
import com.navanee.demo.model.Student;
import com.navanee.demo.repository.CourseRepository;
import com.navanee.demo.repository.StudentRepository;

import java.util.Set;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public Set<Course> getAllCourses() {
        return new HashSet<>(courseRepository.findAll()); // ✅ Convert List to Set
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
       public Course saveCourses(Course course) {
        // ✅ Persist students first and link them to the course
        Set<Student> students = new HashSet<>();
        for (Student student : course.getStudents()) {
            if (student.getId() != null) {
                // If student exists, fetch it from the DB
                student = studentRepository.findById(student.getId())
                          .orElseThrow(() -> new RuntimeException("Student not found"));
            } else {
                student = studentRepository.save(student); // Save new student
            }
            student.getCourses().add(course); // ✅ Establish the relationship
            students.add(student);
        }
        course.setStudents(students);

        // ✅ Save the course with linked students
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
