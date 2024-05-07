package com.example.storereservation.auth.dto;

import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.type.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String name;
    private String phone;
    private String userId;
    private String password;

    public Member convertToMember(PasswordEncoder encoder, Role role) {
        return Member.builder()
                .name(name)
                .phone(phone)
                .userId(userId)
                .password(encoder.encode(password))
                .role(role)
                .regDate(LocalDateTime.now())
                .build();
    }

}
