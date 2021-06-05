package com.indiacleantool.cleantool.datamodels.mobileusermodals.serviceprovidercompany;

import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.users.company.Company;

import java.util.List;

public class ServiceProviderCompanyDetails {
    private Company company;
    private Long availableEmployeeCount;
    private List<TimeSlot> timeSlots;

    public ServiceProviderCompanyDetails(Company company, Long availableEmployeeCount, List<TimeSlot> timeSlots) {
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

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
