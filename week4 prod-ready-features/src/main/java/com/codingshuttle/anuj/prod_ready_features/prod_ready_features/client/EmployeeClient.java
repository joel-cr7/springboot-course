package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.client;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    public List<EmployeeDTO> getAllEmployees();

    public EmployeeDTO getEmployeeById(Long employeeId);

    public EmployeeDTO createEmployee(EmployeeDTO employee);
}
