package com.indiacleantool.cleantool.web.domain.employeeservice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceRelation {

    private String employeeCode;
    private List<String> serviceCodes;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public List<String> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(List<String> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }
}
