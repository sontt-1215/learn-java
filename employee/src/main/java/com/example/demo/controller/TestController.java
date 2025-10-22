package com.example.demo.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final PasswordEncoder encoder;

    public TestController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping("/encode")
    public String encode(@RequestParam String raw) {
        String encoded = encoder.encode(raw);
        return "Encoded: " + encoded + "<br>Matches: " + encoder.matches(raw, encoded);
    }
}
