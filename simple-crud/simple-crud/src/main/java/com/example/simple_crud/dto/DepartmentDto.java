package com.example.simple_crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDto {

    private Long id;
    @NotBlank(message = "Name can't be empty")
    private String name;

}
