package com.example.storereservation.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BusinessNumberValidator implements ConstraintValidator<BusinessNumber, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().equals("")) {
            return false;
        }

        return value.matches("\\d{3}-\\d{2}-\\d{5}+$");
    }

}
