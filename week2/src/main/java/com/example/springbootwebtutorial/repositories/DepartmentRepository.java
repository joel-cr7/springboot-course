package com.example.springbootwebtutorial.repositories;

import com.example.springbootwebtutorial.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
