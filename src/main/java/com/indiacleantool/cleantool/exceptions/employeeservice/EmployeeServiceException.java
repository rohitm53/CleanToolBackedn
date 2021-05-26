package com.indiacleantool.cleantool.exceptions.employeeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeServiceException  extends RuntimeException{
    public EmployeeServiceException(String message) {
        super(message);
    }
}
