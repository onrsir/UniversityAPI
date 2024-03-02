package com.onursir.UniversityAPI.student;

import com.onursir.UniversityAPI.school.entity.School;
import com.onursir.UniversityAPI.student.dto.StudentDto;
import com.onursir.UniversityAPI.student.dto.StudentResponseDto;
import com.onursir.UniversityAPI.student.entity.Student;
import com.onursir.UniversityAPI.student.mapper.StudentMapper;
import com.onursir.UniversityAPI.studentprofile.StudentProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp(){
        studentMapper = new StudentMapper();
    }


    @Test
    void toStudent() {
        StudentDto dto = new StudentDto("Onur","Sir","oonursir@gnail.com",2);
        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(dto.schoolId(), student.getSchool().getId());

        assertNotNull(student.getSchool());

    }

    @Test
    void toStudentResponseDto(){
        Student student = new Student(1,"asda","adsasd","sadads",33,new StudentProfile(),new School());

        StudentResponseDto responseDto = studentMapper.toStudentResponseDto(student);
        assertEquals(responseDto.firstname(),student.getFirstname());
        assertEquals(responseDto.lastname(),student.getLastname());
        assertEquals(responseDto.email(),student.getEmail());

    }


}