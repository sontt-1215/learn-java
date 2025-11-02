package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.security.core.Authentication; 

@Controller
@RequestMapping("/employees")
public class EmployeeDbController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeDbController(EmployeeService employeeService,
                              DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model, Authentication auth) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("role", auth.getAuthorities().toString());
        return "employee_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employees/add";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employee,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departments", departmentService.getAllDepartments());
            return "employees/add";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/list";
    }

    @GetMapping("/search")
    public String searchEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long departmentId,
            Model model) {

        List<Employee> employees = employeeService.searchEmployees(name, departmentId);

        model.addAttribute("employees", employees);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("name", name);
        model.addAttribute("departmentId", departmentId);

        return "employees/search";
    }

    @GetMapping("/employees/statistics")
    public String showStatistics(Model model) {
        model.addAttribute("stats", employeeService.countEmployeesByDepartment());
        model.addAttribute("total", employeeService.getTotalEmployees());
        return "employees/statistics";
    }
}
