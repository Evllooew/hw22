package com.example.dz22;

import com.example.dz22.Exception.EmployeeAlreadyAddedException;
import com.example.dz22.Exception.EmployeeNotFoundException;
import com.example.dz22.Exception.MaximumEmployeeException;
import com.example.dz22.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname, @RequestParam int salary,
                                @RequestParam int department) throws EmployeeAlreadyAddedException {
        return employeeService.addEmployee(name,surname,salary,department);
}




    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surname) throws EmployeeNotFoundException {
        return employeeService.removeEmployee(name,surname);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String surname) throws EmployeeNotFoundException {
        return EmployeeService.findEmployee(name,surname);
    }
}