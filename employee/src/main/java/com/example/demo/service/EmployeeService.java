package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

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

}
