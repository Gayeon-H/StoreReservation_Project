package com.example.storereservation.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND_MEMBER("유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    DUPLICATED_ID("중복된 아이디입니다.", HttpStatus.BAD_REQUEST);

    private final String description;
    private final HttpStatus httpStatus;

}
