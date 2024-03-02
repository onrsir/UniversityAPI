package com.onursir.UniversityAPI.school.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onursir.UniversityAPI.student.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue
    private int id;


    private String name;

    public School(String name, int id) {
        this.name = name;
        this.id = id;
    }
    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;
}
