package com.example.dz22.service;

import com.example.dz22.Employee;
import com.example.dz22.Exception.EmployeeAlreadyAddedException;
import com.example.dz22.Exception.EmployeeNotFoundException;
import com.example.dz22.Exception.MaximumEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private static Map<String, Employee> employeeMap;
    private static final int MAX_EMPLOYEES = 10;

    public EmployeeService() {
        employeeMap = new HashMap<>();
    }

    public Collection<Employee> getEmployeeMap() {
        return employeeMap.values();
    }

    public Employee addEmployee(String name, String surname, int salary, int department) throws MaximumEmployeeException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(name, surname, department, salary);
        if (!employeeMap.containsKey(name + surname)) {
            employeeMap.put(name + surname, employee);
            return employee;
        } else if (employeeMap.size() >= MAX_EMPLOYEES) {
            throw new MaximumEmployeeException("Максимальное количество сотрудников");
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
    }


    public Employee removeEmployee(String name, String surname) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(name + surname)) {
            Employee removedEmployee = employeeMap.remove(name + surname);
            return new Employee(removedEmployee.getName(), removedEmployee.getSurname());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
    @Autowired
    public static Employee findEmployee(String name, String surname) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(name + surname)) {
            return employeeMap.get(name + surname);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}