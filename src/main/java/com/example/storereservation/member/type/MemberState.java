package com.example.storereservation.member.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberState {

    REGISTERED("등록"),
    UNREGISTERED("탈퇴");

    private final String title;

}
