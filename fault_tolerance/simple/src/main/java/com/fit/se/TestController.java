package com.fit.se;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService retryService;

    @GetMapping("/test-retry")
    public String test() throws IOException {
        return retryService.testRetry();
    }

    @GetMapping("/messages")
    public String message() throws InterruptedException {
        return retryService.sendMessage();
    }
}
