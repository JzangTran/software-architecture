package com.fit.se.controller;

import com.fit.se.dto.RegisterRequest;
import com.fit.se.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
         userService.register(request);
    }
}
