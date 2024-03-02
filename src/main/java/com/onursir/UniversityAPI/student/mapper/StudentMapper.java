package com.onursir.UniversityAPI.student.mapper;

import com.onursir.UniversityAPI.school.entity.School;
import com.onursir.UniversityAPI.student.dto.StudentResponseDto;
import com.onursir.UniversityAPI.student.dto.StudentDto;
import com.onursir.UniversityAPI.student.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;

    }

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
