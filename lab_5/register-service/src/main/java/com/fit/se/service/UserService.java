package com.fit.se.service;

import com.fit.se.dto.RegisterRequest;
import com.fit.se.dto.SyncRegisterRequest;
import com.fit.se.model.User;
import com.fit.se.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;
    private final RestTemplate restTemplate;

    public void register(RegisterRequest request) {
        if(userRepo.existsByEmail(request.email())) {
            return;
        }
        User user = userRepo.save(User.builder()
                        .name(request.name())
                        .email(request.email())
                        .password(request.password())
                        .build());

        SyncRegisterRequest syncRequest = SyncRegisterRequest.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        try {
            restTemplate.postForObject(
                    "http://localhost:8082/internal/users",
                    syncRequest,
                    Void.class
            );
        } catch (Exception e) {
            System.out.println("Sync user failed");
        }
    }


}
