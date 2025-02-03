package com.example.springbootwebtutorial.dto;


import com.example.springbootwebtutorial.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Title cannot be empty!")
    @Size(min = 3, max = 20, message = "Title should be in range [3, 20]")
    private String title;

    @AssertTrue
    private boolean isActive;

    @PrimeNumberValidation
    private Integer primeNo;
}
