package com.example.springbootwebtutorial.controllers;

import com.example.springbootwebtutorial.advices.ApiResponse;
import com.example.springbootwebtutorial.dto.DepartmentDTO;
import com.example.springbootwebtutorial.dto.EmployeeDTO;
import com.example.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.example.springbootwebtutorial.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId){
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(departmentId);
        return departmentDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Department with id " + departmentId + " Not found !!"));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO department){
        DepartmentDTO newDepartment = departmentService.createNewDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable Long departmentId,
                                                              @RequestBody @Valid DepartmentDTO department){
        DepartmentDTO updatedDepartment = departmentService.updateDepartmentById(departmentId, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){
        boolean isDeleted = departmentService.deleteDepartmentById(departmentId);
        if(isDeleted)
            return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
