package com.fit.se;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenService jwtTokenService;
    private final RefreshTokenService refreshTokenService;

    public AuthController(
            JwtTokenService jwtTokenService,
            RefreshTokenService refreshTokenService
    ) {
        this.jwtTokenService = jwtTokenService;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {

        // (giả lập) verify user
        String accessToken =
                jwtTokenService.generateAccessToken(request.userName());

        String refreshToken =
                refreshTokenService.createRefreshToken(request.userName());

        return new TokenResponse(accessToken, refreshToken);
    }

    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestBody String refreshToken) {

        String username =
                refreshTokenService.validateAndGetUsername(refreshToken);

        if (username == null) {
            throw new RuntimeException("Invalid refresh token");
        }

        String newAccessToken =
                jwtTokenService.generateAccessToken(username);

        return new TokenResponse(newAccessToken, refreshToken);
    }
}

