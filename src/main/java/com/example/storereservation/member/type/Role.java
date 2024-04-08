package com.example.storereservation.member.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    GENERAL("ROLE_GENERAL"),
    STORE("ROLE_STORE");

    private final String value;

}
