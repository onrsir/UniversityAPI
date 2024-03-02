package com.onursir.UniversityAPI.school;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolRepository schoolRepository;
    private final SchoolService schoolService;

    @PostMapping
    public SchoolDto create(@RequestBody SchoolDto dto){
      return schoolService.create(dto);
    }



    @GetMapping
    public List<SchoolDto> findAll(){
       return schoolService.findAll();
    }


}
