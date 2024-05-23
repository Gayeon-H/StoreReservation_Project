package com.example.storereservation.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

    String message() default "비밀번호는 영문 대,소문자와 숫자, 특수기호가 " +
            "적어도 1개 이상씩 포함된 8~20자의 비밀번호여야 합니다.";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
