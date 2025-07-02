package com.mertalptekin.springrestapidemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_courses",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses;


}

// Not:  @JoinTable formatı ikisinden birinde yeterlidir.
