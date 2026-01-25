package com.fit.se;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RefreshTokenService {

    private final Map<String, String> refreshStore = new ConcurrentHashMap<>();

    public String createRefreshToken(String username) {
        String token = UUID.randomUUID().toString();
        refreshStore.put(token, username);
        return token;
    }

    public String validateAndGetUsername(String refreshToken) {
        return refreshStore.get(refreshToken);
    }
}
