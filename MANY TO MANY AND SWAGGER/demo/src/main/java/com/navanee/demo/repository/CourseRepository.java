package com.navanee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navanee.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {}