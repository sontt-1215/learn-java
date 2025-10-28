package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByDepartment_Id(Long departmentId);
    List<Employee> findByNameContainingIgnoreCaseAndDepartment_Id(String name, Long departmentId);
}
