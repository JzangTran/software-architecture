package com.fit.se.controller;

import com.fit.se.dto.SyncRegisterRequest;
import com.fit.se.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void syncUser(@RequestBody SyncRegisterRequest request) {
        userService.sync(request);
    }
}
