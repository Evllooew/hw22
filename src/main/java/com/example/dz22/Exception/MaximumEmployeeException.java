package com.example.dz22.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MaximumEmployeeException extends RuntimeException {
    public MaximumEmployeeException(String message) {
        super(message);
    }
}