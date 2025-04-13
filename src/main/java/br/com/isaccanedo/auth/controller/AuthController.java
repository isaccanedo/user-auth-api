package br.com.isaccanedo.auth.controller;

import br.com.isaccanedo.auth.dto.LoginRequest;
import br.com.isaccanedo.auth.dto.LoginResponse;
import br.com.isaccanedo.auth.config.JwtService;
import br.com.isaccanedo.auth.service.UserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        // 1. Autentica o usuário
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // 2. Carrega os dados do usuário
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        // 3. Gera o token
        String jwt = jwtService.generateToken(userDetails.getUsername());

        // 4. Retorna o token
        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}
