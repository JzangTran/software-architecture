package com.fit.se;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TestService {
    private AtomicInteger counter = new AtomicInteger();

    @Retry(name = "testRetry", fallbackMethod = "fallback")
    public String testRetry() throws IOException {

        int attempt = counter.incrementAndGet();
        System.out.println("Attempt: " + attempt);

        if (attempt < 2) {
            throw new IOException("Simulated failure");
        }

        return "Success on attempt " + attempt;
    }

    public String fallback(IOException e) {
        return "Fallback executed";
    }

    @RateLimiter(name = "testRateLimiter", fallbackMethod = "fallback")
    @Bulkhead(name = "testBulkhead", fallbackMethod = "fallback")
    public String sendMessage() throws InterruptedException {
        System.out.println("Processing: " + Thread.currentThread().getName());
        Thread.sleep(5000);
        return "Message sent";
    }

    public String fallback(RequestNotPermitted e) {
        return "Too many requests";
    }
}
