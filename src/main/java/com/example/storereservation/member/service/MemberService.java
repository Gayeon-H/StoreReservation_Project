package com.example.storereservation.member.service;

import com.example.storereservation.common.util.PasswordUtils;
import com.example.storereservation.member.dto.JoinDto;
import com.example.storereservation.member.dto.JoinStoreDto;
import com.example.storereservation.member.dto.MemberInfoDto;
import com.example.storereservation.member.dto.MemberUpdateDto;
import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.repository.MemberRepository;
import com.example.storereservation.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

// TODO : 예외 처리
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final StoreService storeService;

    @Transactional
    public Member joinMember(JoinDto joinDto) {
        if (duplicatedMember(joinDto)) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        return memberRepository.save(Member.createMember(joinDto));
    }

    @Transactional
    public void joinStoreMember(JoinStoreDto joinStoreDto) {
        Member member = joinMember(joinStoreDto);

        storeService.saveStore(member.getMemberId(), joinStoreDto);
    }

    private boolean duplicatedMember(JoinDto joinDto) {
        return memberRepository.existsById(joinDto.getId());
    }

    public MemberInfoDto getMemberInfo(Long memberId, String password) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원 없음"));

        if (!member.getPassword().equals(PasswordUtils.encryptPassword(password))) {
            throw new RuntimeException("비번 일치하지 않음");
        }

        return MemberInfoDto.createMemberInfoDto(member);
    }

    @Transactional
    public MemberInfoDto updateMemberInfo(Long memberId, MemberUpdateDto changeInfo) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원 없음"));

        member.setPhone(changeInfo.getPhone());
        member.setPassword(PasswordUtils.encryptPassword(changeInfo.getPassword()));
        member.setUpdateDate(LocalDateTime.now());

        return MemberInfoDto.createMemberInfoDto(member);
    }
}