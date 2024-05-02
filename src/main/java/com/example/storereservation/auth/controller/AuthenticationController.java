package com.example.storereservation.auth.controller;

import com.example.storereservation.auth.dto.AuthenticationRequest;
import com.example.storereservation.auth.dto.AuthenticationResponse;
import com.example.storereservation.auth.dto.RegisterRequest;
import com.example.storereservation.auth.dto.RegisterStoreRequest;
import com.example.storereservation.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register/general")
    public ResponseEntity<AuthenticationResponse> registerGeneral(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registerGeneral(request));
    }

    @PostMapping("/register/store")
    public ResponseEntity<AuthenticationResponse> registerStore(@RequestBody RegisterStoreRequest request) {
        return ResponseEntity.ok(authService.registerStore(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
