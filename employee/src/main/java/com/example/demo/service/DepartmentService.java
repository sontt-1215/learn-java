package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Long id, Department newData) {
        return departmentRepository.findById(id).map(dep -> {
            dep.setName(newData.getName());
            return departmentRepository.save(dep);
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
