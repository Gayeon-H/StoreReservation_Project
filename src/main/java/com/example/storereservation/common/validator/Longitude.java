package com.example.storereservation.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongitudeValidator.class)
public @interface Longitude {

    String message() default "124~132 사이의 경도값을 기입해주세요.";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
