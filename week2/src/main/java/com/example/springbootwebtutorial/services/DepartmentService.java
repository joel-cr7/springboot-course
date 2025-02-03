package com.example.springbootwebtutorial.services;

import com.example.springbootwebtutorial.dto.DepartmentDTO;
import com.example.springbootwebtutorial.entities.DepartmentEntity;
import com.example.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.example.springbootwebtutorial.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper){
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departments = departmentRepository.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .toList();
    }

    public Optional<DepartmentDTO> getDepartmentById(Long departmentId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        return departmentEntity
                .map(department -> modelMapper.map(department, DepartmentDTO.class));
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO department) {
        DepartmentEntity departmentEntity = modelMapper.map(department, DepartmentEntity.class);
        DepartmentEntity departmentEntitySaved = departmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntitySaved, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO department) {
        isExistsDepartmentById(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(department, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long departmentId) {
        isExistsDepartmentById(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    private void isExistsDepartmentById(Long departmentId){
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists)
            throw new ResourceNotFoundException("Department Not Found with id: " + departmentId + " !!");
    }
}
