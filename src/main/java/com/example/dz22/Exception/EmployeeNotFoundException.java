package com.example.dz22.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String сотрудникНеНайден) {
        super(сотрудникНеНайден);
    }
}