package com.navanee.demo.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.HashSet;


@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    //@JsonIgnore
    private Set<Course> courses = new HashSet<>(); // ✅ Changed to Set to remove duplicates
}
