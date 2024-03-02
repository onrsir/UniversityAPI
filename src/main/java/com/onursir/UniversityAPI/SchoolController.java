package com.onursir.UniversityAPI;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolRepository schoolRepository;


    @PostMapping
    public SchoolDto create(@RequestBody SchoolDto dto){
        var school = toSchool(dto);
        schoolRepository.save(school);

        return dto;
    }

    private School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }

    private SchoolDto toSchoolDto(School school){
        return new SchoolDto((school.getName()));
    }

    @GetMapping
    public List<SchoolDto> findAll(){
        return schoolRepository.findAll().stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }


}
