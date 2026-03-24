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
                        .id(request.id())
                        .name(request.name())
                        .email(request.email())
                        .password(request.password())
                        .build());
    }

    public boolean validateUser(String email, String password) throws Exception {
        User user = userRepo.findByEmail((email));

        if (user == null) throw new Exception();

        if (!password.equals(user.getPassword())) {
            throw new Exception();
        }

        return true;
    }
}
