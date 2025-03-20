package com.navanee.demo.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.navanee.demo.model.Course;
import com.navanee.demo.service.CourseService;

import java.util.Set;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public Set<Course> getAllCourses() {
        return courseService.getAllCourses(); // ✅ Return Set instead of List
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
   

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}


 