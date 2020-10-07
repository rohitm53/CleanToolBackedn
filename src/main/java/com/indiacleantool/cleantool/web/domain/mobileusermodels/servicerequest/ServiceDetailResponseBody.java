package com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest;

import com.indiacleantool.cleantool.web.domain.users.company.Company;

public class ServiceDetailResponse {

    private Company company;
    private Long availableEmployeeCount;
    private Error error;

    public ServiceDetailResponse(Company company, Long availableEmployeeCount,Error error) {
        this.company = company;
        this.availableEmployeeCount = availableEmployeeCount;
        this.error=error;
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

    class Error {
        private String error;

        public Error(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

}
