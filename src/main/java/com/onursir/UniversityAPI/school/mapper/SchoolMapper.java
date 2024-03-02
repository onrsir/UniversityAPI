package com.onursir.UniversityAPI.school.mapper;

import com.onursir.UniversityAPI.school.dto.SchoolDto;
import com.onursir.UniversityAPI.school.entity.School;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolMapper {
    public School toSchool(SchoolDto dto) {
        return new School(dto.name(),
                dto.id() );
    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName(),
        school.getId() );
    }


}
