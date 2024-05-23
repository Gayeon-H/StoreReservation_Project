package com.example.storereservation.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().equals("")) {
            return false;
        }

        return value.matches("(?=.*\\d)(?=.*[a-zA-Z])(?=.*\\W).{8,20}+$");
    }

}
