package com.onursir.UniversityAPI.school;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;
    public SchoolDto create(@RequestBody SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);

        return dto;
    }

    public List<SchoolDto> findAll(){
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
