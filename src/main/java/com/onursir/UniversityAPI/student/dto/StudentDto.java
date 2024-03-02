package com.onursir.UniversityAPI.student.dto;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto (
        @NotEmpty
        String firstname,
        @NotEmpty
        String lastname,
        String email,
        Integer schoolId

) {



}
