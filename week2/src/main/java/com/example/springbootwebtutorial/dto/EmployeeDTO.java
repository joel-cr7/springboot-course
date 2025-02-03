package com.example.springbootwebtutorial.dto;

import com.example.springbootwebtutorial.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Employee name cannot be blank")
    @Size(min = 2, max = 10, message = "Name should be in range: [2, 10]")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Age of employee cannot be null")
    @Min(value = 18, message = "Age must be greater than 18")
    @Max(value = 80, message = "Age must be less than 80")
    private Integer age;

    @NotBlank(message = "Role cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can be USER or ADMIN")
    @EmployeeRoleValidation   // using custom validation
    private String role;

    @NotNull(message = "Salary cannot be null")
    @Positive(message = "Salary should be positive number")
    @Digits(integer = 6, fraction = 2, message = "salary is invalid")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining cannot be in future")
    private LocalDate dateOfJoining;

    private Boolean empIsActive;
}
