package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Cacheable("employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchEmployees(String name, Long departmentId) {
        if (departmentId != null && (name != null && !name.isEmpty())) {
            return employeeRepository.findByNameContainingIgnoreCaseAndDepartment_Id(name, departmentId);
        } else if (departmentId != null) {
            return employeeRepository.findByDepartment_Id(departmentId);
        } else if (name != null && !name.isEmpty()) {
            return employeeRepository.findByNameContainingIgnoreCase(name);
        }
        return employeeRepository.findAll();
    }

    public List<Map<String, Object>> countEmployeesByDepartment() {
        List<Object[]> results = employeeRepository.countEmployeesByDepartment();
        List<Map<String, Object>> stats = new ArrayList<>();

        for (Object[] row : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("department", row[0]);
            map.put("count", row[1]);
            stats.add(map);
        }

        return stats;
    }

    public Long getTotalEmployees() {
        return employeeRepository.countTotalEmployees();
    }
}
