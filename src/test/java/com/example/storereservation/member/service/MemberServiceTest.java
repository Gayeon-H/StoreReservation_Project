package com.example.storereservation.member.service;

import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.repository.MemberRepository;
import com.example.storereservation.member.type.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberServiceImpl memberService;
    @Mock
    private MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DisplayName("멤버 추가")
    @Test
    void addMember() {
        // given
        Member member = member();
        Member entity = memberEntity();
        when(memberRepository.save(member)).thenReturn(entity);

        // when
        Member result = memberService.addMember(member);

        // then
        assertEquals(result.getName(), member.getName());
        verify(memberRepository, times(1)).save(member);
    }

    @DisplayName("멤버 찾기")
    @Test
    void findMember() {
        // given
        Member entity = memberEntity();
        when(memberRepository.findByUserId("testId")).thenReturn(Optional.of(entity));

        // when
        Member result = memberService.findMember("testId");

        // then
        assertEquals(result.getMemberId(), entity.getMemberId());
        verify(memberRepository, times(1)).findByUserId("testId");
    }

    @DisplayName("멤버 찾기_예외 발생")
    @Test
    void findMember_exception() {
        // given
        when(memberRepository.findByUserId("testId")).thenReturn(Optional.empty());

        // when
        // then
        assertThrows(RuntimeException.class, () -> memberService.findMember("testId"));
    }

    @DisplayName("중복 아이디 체크")
    @Test
    void checkDuplicatedId() {
        // given
        when(memberRepository.existsByUserId("test")).thenReturn(false);

        // when
        boolean result = memberService.checkDuplicatedId("test");

        // then
        assertTrue(result);
        verify(memberRepository, times(1)).existsByUserId("test");
    }

    @DisplayName("중복 아이디 체크_예외 발생")
    @Test
    void checkDuplicatedId_exception() {
        // given
        when(memberRepository.existsByUserId("testId")).thenReturn(true);

        // when
        // then
        assertThrows(RuntimeException.class, () -> memberService.checkDuplicatedId("testId"));
    }

    private Member member() {
        return Member.builder()
                .name("사용자")
                .phone("01012341234")
                .userId("testId")
                .password(passwordEncoder.encode("testPassword"))
                .role(Role.GENERAL)
                .build();
    }

    private Member memberEntity() {
        Member entity = member();
        entity.setMemberId(1L);
        return entity;
    }

}