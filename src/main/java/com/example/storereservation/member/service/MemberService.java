package com.example.storereservation.member.service;

import com.example.storereservation.member.entity.Member;

public interface MemberService {

    Member addMember(Member member);

    Member findMember(String userId);

    boolean checkDuplicatedId(String userId);

}
