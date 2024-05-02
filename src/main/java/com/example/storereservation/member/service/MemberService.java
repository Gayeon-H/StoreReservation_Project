package com.example.storereservation.member.service;

import com.example.storereservation.member.entity.Member;

public interface MemberService {

    void addMember(Member member);

    Member findMember(String userId);

    void checkDuplicatedId(String userId);

}
