package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UtilityService {
    public String generateEmployeeCode() {
        return "EMP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String formatName(String name) {
        if (name == null || name.isEmpty()) return name;
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
    }
}
