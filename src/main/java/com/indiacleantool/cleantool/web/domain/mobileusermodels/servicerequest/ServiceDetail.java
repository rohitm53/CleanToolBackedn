package com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest;

import com.indiacleantool.cleantool.web.domain.users.company.Company;

public class ServiceDetail {
    private Company company;
    private Long availableEmployeeCount;

    public ServiceDetail(Company company, Long availableEmployeeCount) {
        this.company = company;
        this.availableEmployeeCount = availableEmployeeCount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getAvailableEmployeeCount() {
        return availableEmployeeCount;
    }

    public void setAvailableEmployeeCount(Long availableEmployeeCount) {
        this.availableEmployeeCount = availableEmployeeCount;
    }
}
