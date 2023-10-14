package com.example.dz22.Exception;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String сотрудникНеНайден) {
        super(сотрудникНеНайден);
    }
}