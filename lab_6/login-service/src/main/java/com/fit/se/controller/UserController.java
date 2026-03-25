package com.fit.se.controller;

import com.fit.se.dto.SyncRegisterRequest;
import com.fit.se.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8386")
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void syncUser(@RequestBody SyncRegisterRequest request) {
        userService.sync(request);
    }
}
