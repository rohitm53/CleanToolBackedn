package com.indiacleantool.cleantool.web.models.mobileusermodals.serviceprovidercompany;

import com.indiacleantool.cleantool.web.models.common.timeslots.TimeSlots;
import com.indiacleantool.cleantool.web.models.users.company.Company;

import java.util.List;

public class ServiceProviderCompanyDetails {
    private Company company;
    private Long availableEmployeeCount;
    private List<TimeSlots> timeSlots;

    public ServiceProviderCompanyDetails(Company company, Long availableEmployeeCount, List<TimeSlots> timeSlots) {
        this.company = company;
        this.availableEmployeeCount = availableEmployeeCount;
        this.timeSlots = timeSlots;
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

    public List<TimeSlots> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlots> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
