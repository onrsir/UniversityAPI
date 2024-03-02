package com.onursir.UniversityAPI.studentprofile;

import com.onursir.UniversityAPI.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfile {
    @Id
    @GeneratedValue
    private int id;

    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
