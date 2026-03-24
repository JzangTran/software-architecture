package com.fit.se.dto;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {}
