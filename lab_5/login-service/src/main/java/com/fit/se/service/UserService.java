package com.fit.se.service;

import com.fit.se.dto.SyncRegisterRequest;
import com.fit.se.model.User;
import com.fit.se.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public void sync(SyncRegisterRequest request) {
        if(userRepo.existsByEmail(request.email())) {
            return;
        }
        userRepo.save(User.builder()
                        .name(request.name())
                        .email(request.email())
                        .password(request.password())
                        .build());
    }
}
