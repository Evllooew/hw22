package com.example.dz22;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployeeInDepartment(@RequestParam int departmentId) {
        return departmentService.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployeeInDepartment(@RequestParam int departmentId) {
        return departmentService.findMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/total-salary-cost")
    public double getTotalSalaryCostByDepartment(@RequestParam int departmentId) {
        return departmentService.getTotalSalaryCostByDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeesInDepartment(@RequestParam int departmentId) {
        return (List<Employee>) departmentService.getAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployees();
    }
}