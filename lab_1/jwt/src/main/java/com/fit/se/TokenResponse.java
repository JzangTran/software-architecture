package com.fit.se;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {}
