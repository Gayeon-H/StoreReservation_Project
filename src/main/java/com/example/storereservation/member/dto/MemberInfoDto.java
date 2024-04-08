package com.example.storereservation.member.dto;

import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.type.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDto {

    private String id;
    private String name;
    private String phone;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public static MemberInfoDto createMemberInfoDto(Member member) {
        return MemberInfoDto.builder()
                .id(member.getId())
                .name(member.getName())
                .phone(member.getPhone())
                .role(member.getRole())
                .build();
    }
}
