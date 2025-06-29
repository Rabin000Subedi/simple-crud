package com.example.simple_crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

}
