package com.example.storereservation.member.service;

import com.example.storereservation.common.exception.CustomRuntimeException;
import com.example.storereservation.common.exception.ErrorCode;
import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService, UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findMember(String userId) {
        return memberRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomRuntimeException(ErrorCode.NOT_FOUND_MEMBER));
    }

    @Override
    public boolean checkDuplicatedId(String userId) {
        if (memberRepository.existsByUserId(userId)) {
            throw new CustomRuntimeException(ErrorCode.DUPLICATED_ID);
        }

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) {
        return memberRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다."));
    }

}
