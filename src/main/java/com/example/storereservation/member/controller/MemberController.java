package com.example.storereservation.member.controller;

import com.example.storereservation.member.dto.*;
import com.example.storereservation.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO : valid 체크
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/public/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto) {
        memberService.joinMember(joinDto);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    @PostMapping("/public/join")
    public ResponseEntity<String> join(@RequestBody JoinStoreDto joinStoreDto) {
        memberService.joinStoreMember(joinStoreDto);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    // TODO
    @PostMapping("/public/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok("jwt access token");
    }

    // TODO
    @DeleteMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("logout");
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<MemberInfoDto> getMemberInfo(@PathVariable Long memberId,
                                                       @RequestBody String password) {
        return ResponseEntity.ok(memberService.getMemberInfo(memberId, password));
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberInfoDto> updateMemberInfo(@PathVariable Long memberId,
                                                          @RequestBody MemberUpdateDto changeInfo) {
        return ResponseEntity.ok(memberService.updateMemberInfo(memberId, changeInfo));
    }

    // TODO
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> withdraw(@PathVariable Long memberId) {
        return ResponseEntity.ok("withdraw");
    }

}
