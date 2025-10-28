package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("department", new Department());
        return "departments/add";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid @ModelAttribute("department") Department department,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "departments/add";
        }
        departmentService.saveDepartment(department);
        return "redirect:/departments/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("departments", departmentService.searchByName(keyword));
        model.addAttribute("keyword", keyword);
        return "departments/list";
    }
}
