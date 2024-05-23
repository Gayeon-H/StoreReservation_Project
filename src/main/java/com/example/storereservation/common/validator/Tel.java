package com.example.storereservation.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelValidator.class)
public @interface Tel {

    String message() default "연락처는 형식에 맞게 입력해주세요. " +
            "ex) 010-1111-2222";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
