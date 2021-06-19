package com.indiacleantool.cleantool.exceptions.userexception.employees;

public class EmployeeCodeExceptionResponse {

    private String employeeCode;

    public EmployeeCodeExceptionResponse(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}
