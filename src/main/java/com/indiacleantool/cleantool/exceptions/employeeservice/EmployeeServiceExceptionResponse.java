package com.indiacleantool.cleantool.exceptions.employeeservice;

public class EmployeeServiceExceptionResponse {

    private String error;

    public EmployeeServiceExceptionResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
