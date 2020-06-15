package com.indiacleantool.cleantool.web.domain.companydashboard;

public class DashboardReportResponse {

    private Integer serviceCount=0;
    private Integer employeeCount=0;
    private Integer assetCount=0;

    public DashboardReportResponse() {
    }

    public DashboardReportResponse(Integer serviceCount, Integer employeeCount, Integer assetCount) {
        this.serviceCount = serviceCount;
        this.employeeCount = employeeCount;
        this.assetCount = assetCount;
    }

    public Integer getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(Integer serviceCount) {
        this.serviceCount = serviceCount;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Integer getAssetCount() {
        return assetCount;
    }

    public void setAssetCount(Integer assetCount) {
        this.assetCount = assetCount;
    }
}
