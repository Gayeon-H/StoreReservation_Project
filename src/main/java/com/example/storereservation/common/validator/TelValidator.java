package com.example.storereservation.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelValidator implements ConstraintValidator<Tel, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().equals("")) {
            return false;
        }

        return value.matches("\\d{2,3}-\\d{3,4}-\\d{4}+$");
    }

}
