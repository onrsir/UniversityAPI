package com.onursir.UniversityAPI.school.dao;

import com.onursir.UniversityAPI.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
