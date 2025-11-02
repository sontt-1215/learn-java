package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByDepartment_Id(Long departmentId);
    List<Employee> findByNameContainingIgnoreCaseAndDepartment_Id(String name, Long departmentId);

    @Query("SELECT e.department.name, COUNT(e) FROM Employee e GROUP BY e.department.name")
    List<Object[]> countEmployeesByDepartment();

    @Query("SELECT COUNT(e) FROM Employee e")
    Long countTotalEmployees();
}
