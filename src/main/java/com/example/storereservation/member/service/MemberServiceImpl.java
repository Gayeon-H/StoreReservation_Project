package com.example.storereservation.member.service;

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
                .orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 잘못 입력되었습니다."));
    }

    @Override
    public boolean checkDuplicatedId(String userId) {
        if (memberRepository.existsByUserId(userId)) {
            throw new RuntimeException("중복되는 아이디입니다.");
        }

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) {
        return memberRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다."));
    }

}
