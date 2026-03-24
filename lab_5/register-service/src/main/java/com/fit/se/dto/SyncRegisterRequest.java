package com.fit.se.dto;

import lombok.Builder;

@Builder
public record SyncRegisterRequest(
        String id,
        String name,
        String email,
        String password
) {}
