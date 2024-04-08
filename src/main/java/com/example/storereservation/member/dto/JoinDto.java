package com.example.storereservation.member.dto;

import com.example.storereservation.member.type.Role;
import lombok.Getter;

@Getter
public class JoinDto {

    private String name;
    private String id;
    private String password;
    private String phone;
    private Role role;

}
