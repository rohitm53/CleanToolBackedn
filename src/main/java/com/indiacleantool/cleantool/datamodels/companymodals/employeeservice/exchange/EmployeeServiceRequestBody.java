package com.indiacleantool.cleantool.datamodels.companymodals.employeeservice.exchange;

import java.util.ArrayList;

public class EmployeeServiceRequestBody {

    private String employeeCode;
    private ArrayList<String> serviceCodes;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public ArrayList<String> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(ArrayList<String> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }
}
