package com.onursir.UniversityAPI.student;

import com.onursir.UniversityAPI.school.entity.School;
import com.onursir.UniversityAPI.student.dao.StudentRepository;
import com.onursir.UniversityAPI.student.dto.StudentDto;
import com.onursir.UniversityAPI.student.dto.StudentResponseDto;
import com.onursir.UniversityAPI.student.entity.Student;
import com.onursir.UniversityAPI.student.mapper.StudentMapper;
import com.onursir.UniversityAPI.student.services.StudentService;
import com.onursir.UniversityAPI.studentprofile.StudentProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveStudent_should_return_student_response_dto() {
        // Given
        StudentDto studentDto = new StudentDto("John", "Doe","dance",2);
        Student student = new Student(1, "John", "Doe","dance",24,new StudentProfile(),new School());
        StudentResponseDto expectedResponseDto = new StudentResponseDto("John", "Doe", "dance");

        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toStudentResponseDto(student)).thenReturn(expectedResponseDto);

        // When
        StudentResponseDto actualResponseDto = studentService.saveStudent(studentDto);

        // Then
        assertEquals(expectedResponseDto, actualResponseDto);
        verify(studentMapper, times(1)).toStudent(studentDto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDto(student);
    }

    @Test
    void getAll_should_return_list_of_student_response_dto() {
        // Given
        Student student = new Student(1, "John", "Doe","dance",24,new StudentProfile(),new School());
        StudentResponseDto expectedResponseDto = new StudentResponseDto("John", "Doe", "dance");

        when(studentRepository.findAll()).thenReturn(Collections.singletonList(student));
        when(studentMapper.toStudentResponseDto(student)).thenReturn(expectedResponseDto);

        // When
        List<StudentResponseDto> actualResponseDtos = studentService.getAll();

        // Then
        assertEquals(1, actualResponseDtos.size());
        assertEquals(expectedResponseDto, actualResponseDtos.get(0));
        verify(studentRepository, times(1)).findAll();
        verify(studentMapper, times(1)).toStudentResponseDto(student);
    }

    // Add other test cases for other methods in StudentService
}
