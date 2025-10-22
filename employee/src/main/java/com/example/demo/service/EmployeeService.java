package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UtilityService utilityService;

    public EmployeeService(EmployeeRepository employeeRepository, UtilityService utilityService) {
        this.employeeRepository = employeeRepository;
        this.utilityService = utilityService;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        employee.setEmployeeCode(utilityService.generateEmployeeCode());
        employee.setName(utilityService.formatName(employee.getName()));
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(Long id, Employee updated) {
        return employeeRepository.findById(id)
                .map(e -> {
                    e.setName(utilityService.formatName(updated.getName()));
                    e.setDepartment(updated.getDepartment());
                    e.setSalary(updated.getSalary());
                    return employeeRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }
}
