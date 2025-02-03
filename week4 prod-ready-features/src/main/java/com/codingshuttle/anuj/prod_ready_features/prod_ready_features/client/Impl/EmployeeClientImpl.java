package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.client.Impl;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.client.EmployeeClient;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.trace("Trying to retrieve all employees");
        try {
            ApiResponse<List<EmployeeDTO>> response = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error("400 Error occurred: {}", new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved all employees");
            log.trace("Retrieved employees list: {}", response.getData());
            return response.getData();
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("Trying to retrieve employee by id: {}", employeeId);
        try {
            ApiResponse<EmployeeDTO> response = restClient.get()
                    .uri("employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error("400 Error occurred: {}", new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.debug("Successfully retrieved all employees");
            log.trace("Retrieved employees list: {}", response.getData());
            return response.getData();
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees: ", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        log.trace("Trying to create employee with information: {}", employee);
        try {
            ResponseEntity<ApiResponse<EmployeeDTO>> createdEmployee = restClient.post()
                    .uri("/employees")
                    .body(employee)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error("Error occurred: {}",  new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("could not create employee");
                    })
                    .toEntity(new ParameterizedTypeReference<>() {
                    });
            log.trace("Successfully created new employee: {}", createdEmployee.getBody());
            return createdEmployee.getBody().getData();
        } catch (Exception e) {
            log.error("Exception occurred in createEmployee: ", e);
            throw new RuntimeException(e);
        }
    }
}
