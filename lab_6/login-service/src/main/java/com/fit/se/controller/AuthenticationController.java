package com.fit.se.controller;

import com.fit.se.config.JwtTokenService;
import com.fit.se.config.RefreshTokenService;
import com.fit.se.dto.LoginRequest;
import com.fit.se.dto.TokenResponse;
import com.fit.se.model.User;
import com.fit.se.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtTokenService jwtTokenService;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) throws Exception {
        if(!userService.validateUser(request.email(), request.password())) {
            throw new Exception();
        }

        String accessToken =
                jwtTokenService.generateAccessToken(request.email());

        String refreshToken =
                refreshTokenService.createRefreshToken(request.email());

        return new TokenResponse(accessToken, refreshToken);
    }
}
