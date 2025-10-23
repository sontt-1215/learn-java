package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/db/employees")
public class EmployeeDbController {

    private final EmployeeService employeeService;

    public EmployeeDbController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String department) {
        if (name != null)
            return employeeService.searchByName(name);
        if (department != null)
            return employeeService.searchByDepartment(department);
        return employeeService.getAllEmployees();
    }
}
