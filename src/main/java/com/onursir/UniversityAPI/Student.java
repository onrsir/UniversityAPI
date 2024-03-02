package com.onursir.UniversityAPI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private int age;

    /*@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private StudentProfile studentProfile;*/

    @ManyToOne
    @JoinColumn(name = "school_id",referencedColumnName = "id")
    @JsonBackReference
    private School school;
}
