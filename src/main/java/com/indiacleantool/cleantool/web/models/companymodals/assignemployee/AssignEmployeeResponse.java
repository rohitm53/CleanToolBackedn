package com.indiacleantool.cleantool.web.models.companymodals.assignemployee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.indiacleantool.cleantool.web.models.common.errormodels.Error;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssignEmployeeResponse {


    private String serviceReqCode;

    private String assignedEmployeeCode;

    private  int statusCode;

    private  String statusName;

    private Error error;

    public AssignEmployeeResponse() {
    }

    public AssignEmployeeResponse(String serviceReqCode, String assignedEmployeeCode, int statusCode, String statusName) {
        this.serviceReqCode = serviceReqCode;
        this.assignedEmployeeCode = assignedEmployeeCode;
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public AssignEmployeeResponse(Error error) {
        this.error = error;
    }

    public String getServiceReqCode() {
        return serviceReqCode;
    }

    public void setServiceReqCode(String serviceReqCode) {
        this.serviceReqCode = serviceReqCode;
    }

    public String getAssignedEmployeeCode() {
        return assignedEmployeeCode;
    }

    public void setAssignedEmployeeCode(String assignedEmployeeCode) {
        this.assignedEmployeeCode = assignedEmployeeCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
