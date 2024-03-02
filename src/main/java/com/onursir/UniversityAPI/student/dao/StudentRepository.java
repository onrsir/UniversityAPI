package com.onursir.UniversityAPI.student.dao;

import com.onursir.UniversityAPI.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

        List<Student> findAllByFirstnameContaining(String firstname);
}
