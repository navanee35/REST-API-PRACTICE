package com.navanee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navanee.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}