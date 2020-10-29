package com.indiacleantool.cleantool.web.frontendmodules.assignemployee;

public class AssignEmployee {

    private Long serviceRequestId;

    private String serviceReqCode;

    private Long assignenEmployeeId;

    private String assignedEmployeeCode;

    public AssignEmployee() {
    }

    public AssignEmployee(Long serviceRequestId, String serviceReqCode, Long assignenEmployeeId, String assignedEmployeeCode) {
        this.serviceRequestId = serviceRequestId;
        this.serviceReqCode = serviceReqCode;
        this.assignenEmployeeId = assignenEmployeeId;
        this.assignedEmployeeCode = assignedEmployeeCode;
    }

    public Long getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(Long serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getServiceReqCode() {
        return serviceReqCode;
    }

    public void setServiceReqCode(String serviceReqCode) {
        this.serviceReqCode = serviceReqCode;
    }

    public Long getAssignenEmployeeId() {
        return assignenEmployeeId;
    }

    public void setAssignenEmployeeId(Long assignenEmployeeId) {
        this.assignenEmployeeId = assignenEmployeeId;
    }

    public String getAssignedEmployeeCode() {
        return assignedEmployeeCode;
    }

    public void setAssignedEmployeeCode(String assignedEmployeeCode) {
        this.assignedEmployeeCode = assignedEmployeeCode;
    }
}
