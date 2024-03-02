package com.onursir.UniversityAPI.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

        List<Student> findAllByFirstnameContaining(String firstname);
}
