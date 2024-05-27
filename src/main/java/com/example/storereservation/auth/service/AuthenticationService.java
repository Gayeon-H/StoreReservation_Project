package com.example.storereservation.auth.service;

import com.example.storereservation.auth.dto.AuthenticationRequest;
import com.example.storereservation.auth.dto.AuthenticationResponse;
import com.example.storereservation.auth.dto.RegisterRequest;
import com.example.storereservation.auth.dto.RegisterStoreRequest;
import com.example.storereservation.common.exception.CustomRuntimeException;
import com.example.storereservation.common.exception.ErrorCode;
import com.example.storereservation.config.security.JwtService;
import com.example.storereservation.member.entity.Member;
import com.example.storereservation.member.service.MemberService;
import com.example.storereservation.member.type.Role;
import com.example.storereservation.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberService memberService;
    private final StoreService storeService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponse registerGeneral(RegisterRequest request) {
        Member member = registerMember(request, Role.GENERAL);
        String jwtToken = jwtService.generateToken(member);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerStore(RegisterStoreRequest request) {
        Member member = registerMember(request, Role.STORE);
        storeService.registerStore(member.getMemberId(), request);
        String jwtToken = jwtService.generateToken(member);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Member member = memberService.findMember(request.getUserId());
        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new CustomRuntimeException(
                    ErrorCode.NOT_FOUND_MEMBER, "아이디 또는 비밀번호가 잘못 입력되었습니다."
            );
        }
        String jwtToken = jwtService.generateToken(member);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private Member registerMember(RegisterRequest request, Role role) {
        memberService.checkDuplicatedId(request.getUserId());
        Member member = request.convertToMember(passwordEncoder, role);

        return memberService.addMember(member);
    }

}
