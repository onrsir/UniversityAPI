package com.onursir.UniversityAPI.school.controller;


import com.onursir.UniversityAPI.school.dto.SchoolDto;
import com.onursir.UniversityAPI.school.services.SchoolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    public SchoolDto create(@Valid @RequestBody SchoolDto dto){
      return schoolService.create(dto);
    }
    @GetMapping
    public List<SchoolDto> findAll(){
       return schoolService.findAll();
    }

}
