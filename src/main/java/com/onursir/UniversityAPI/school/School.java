package com.onursir.UniversityAPI.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onursir.UniversityAPI.student.Student;
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

    public School(String name) {
        this.name = name;
    }

    private String name;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;
}
