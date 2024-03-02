package com.onursir.UniversityAPI;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto post(@RequestBody StudentDto dto){

        var student = toStudent(dto);
        var savedStudent = studentRepository.save(student);

        return toStudentResponseDto(savedStudent);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Student getById(@PathVariable int id){
        return studentRepository.findById(id).orElse(new Student());
    }

    @GetMapping("/search/{name}")
    public List<Student> findStudentByName(@PathVariable String name){
        return studentRepository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id){
        studentRepository.deleteById(id);
    }


    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;

    }

    private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
