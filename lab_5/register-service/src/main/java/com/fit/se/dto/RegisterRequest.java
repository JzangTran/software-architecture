package com.fit.se.dto;

public record RegisterRequest(
        String name,
        String email,
        String password
) {}
