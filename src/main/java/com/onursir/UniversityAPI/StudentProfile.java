package com.onursir.UniversityAPI;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

 /*   @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
*/


}
