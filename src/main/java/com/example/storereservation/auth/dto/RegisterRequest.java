package com.example.storereservation.auth.dto;

import com.example.storereservation.common.validator.Password;
import com.example.storereservation.common.validator.Tel;
import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.type.Role;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "이름은 필수입력값입니다.")
    @Max(value = 20, message = "이름은 최대 20자까지 가능합니다")
    private String name;
    @Tel
    private String phone;
    @NotBlank(message = "아이디는 필수입력값입니다.")
    @Max(value = 20, message = "아이디는 최대 20자까지 가능합니다.")
    private String userId;
    @Password
    private String password;

    public Member convertToMember(PasswordEncoder encoder, Role role) {
        return Member.builder()
                .name(name)
                .phone(phone)
                .userId(userId)
                .password(encoder.encode(password))
                .role(role)
                .build();
    }

}
