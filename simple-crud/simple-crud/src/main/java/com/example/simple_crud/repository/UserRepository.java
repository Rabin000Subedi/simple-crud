package com.example.simple_crud.repository;

import com.example.simple_crud.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE (:departmentId IS NULL OR u.department.id = :departmentId)")
    Page<User> findByDepartmentId(@Param("departmentId") Long departmentId, Pageable pageable);
}
