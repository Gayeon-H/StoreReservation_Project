package com.example.storereservation.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String errorCode;
    private String message;

}
