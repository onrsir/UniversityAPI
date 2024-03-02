package com.onursir.UniversityAPI.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto save(@RequestBody StudentDto dto){
        return this.studentService.saveStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/find/{id}")
    public StudentResponseDto getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @GetMapping("/search/{name}")
    public List<StudentResponseDto> findStudentByName(@PathVariable String name){
        return studentService.findStudentByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id){
        studentService.deleteById(id);
    }

}
