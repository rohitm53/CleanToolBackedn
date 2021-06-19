package com.indiacleantool.cleantool.datamodels.companymodals.assignemployee.exchange.availableemployee;

import com.indiacleantool.cleantool.datamodels.users.employee.Employee;

import java.util.List;

public class AvailableEmployeeResponse {

    private List<Employee> availableEmployees;

    public AvailableEmployeeResponse(List<Employee> availableEmployees) {
        this.availableEmployees = availableEmployees;
    }

    public List<Employee> getAvailableEmployees() {
        return availableEmployees;
    }

    public void setAvailableEmployees(List<Employee> availableEmployees) {
        this.availableEmployees = availableEmployees;
    }
}
