package com.fit.se.dto;

public record SyncRegisterRequest(
        String id,
        String name,
        String email,
        String password
) {}
