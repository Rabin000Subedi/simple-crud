package com.example.simple_crud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class UserDto {
    private Long id;
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email must be valid")
    private String email;
    @NotNull(message = "Department ID is required")
    private Long departmentId;
}
