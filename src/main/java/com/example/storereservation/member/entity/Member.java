package com.example.storereservation.member.entity;

import com.example.storereservation.common.util.PasswordUtils;
import com.example.storereservation.member.dto.JoinDto;
import com.example.storereservation.member.type.MemberState;
import com.example.storereservation.member.type.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String id;
    private String password;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private Role role; // 회원 종류
    @Enumerated(value = EnumType.STRING)
    private MemberState memberState; // 회원 상태

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public static Member createMember(JoinDto joinDto) {
        return Member.builder()
                .name(joinDto.getName())
                .id(joinDto.getId())
                .password(PasswordUtils.encryptPassword(joinDto.getPassword()))
                .phone(joinDto.getPhone())
                .role(joinDto.getRole())
                .memberState(MemberState.REGISTERED)
                .regDate(LocalDateTime.now())
                .build();
    }

}
