package com.example.springbootwebtutorial.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;




@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { PrimeNumberValidator.class })
public @interface PrimeNumberValidation {
    String message() default "Number provided should be prime !!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
