package com.example.simple_crud.service;

import com.example.simple_crud.dto.DepartmentDto;
import com.example.simple_crud.entity.Department;
import com.example.simple_crud.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    // Create a department
    public DepartmentDto createDepartment(DepartmentDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department = departmentRepository.save(department);
        dto.setId(department.getId());
        return dto;
    }

    // Get all departments
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(dept -> {
                    DepartmentDto dto = new DepartmentDto();
                    dto.setId(dept.getId());
                    dto.setName(dept.getName());
                    return dto;
                })
                .toList();
    }
}