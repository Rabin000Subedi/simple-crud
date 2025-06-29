package com.example.simple_crud.service;

import com.example.simple_crud.dto.UserDto;
import com.example.simple_crud.entity.Department;
import com.example.simple_crud.entity.User;
import com.example.simple_crud.repository.DepartmentRepository;
import com.example.simple_crud.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    // Create a user
    public UserDto createUser(UserDto dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setDepartment(department);
        user = userRepository.save(user);
        dto.setId(user.getId());
        return dto;
    }
    public UserDto updateUser(Long id, UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setDepartment(department);
        userRepository.save(user);
        return dto;
    }

    // Get a user by ID
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setDepartmentId(user.getDepartment().getId());
        return dto;
    }
    // Delete a user
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

    // Get users with pagination and filtering
    public Page<UserDto> getUsers(Long departmentId, Pageable pageable) {
        return userRepository.findByDepartmentId(departmentId, pageable)
                .map(user -> {
                    UserDto dto = new UserDto();
                    dto.setId(user.getId());
                    dto.setName(user.getName());
                    dto.setEmail(user.getEmail());
                    dto.setDepartmentId(user.getDepartment().getId());
                    return dto;
                });
    }

}
