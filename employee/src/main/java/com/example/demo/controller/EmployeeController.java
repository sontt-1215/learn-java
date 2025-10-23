package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final List<Map<String, Object>> employees = new ArrayList<>();

    public EmployeeController() {
        employees.add(Map.of("id", 1, "name", "Sơn", "email", "son@example.com", "department", "IT"));
        employees.add(Map.of("id", 2, "name", "Hà", "email", "ha@example.com", "department", "HR"));
    }

    @GetMapping
    public List<Map<String, Object>> getAll() {
        return employees;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> newEmployee) {
        newEmployee.put("id", employees.size() + 1);
        employees.add(newEmployee);
        return newEmployee;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable int id) {
        return employees.stream()
                .filter(emp -> emp.get("id").equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
