package com.indiacleantool.cleantool.datamodels.mobileusermodals.serviceprovidercompany;

import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.users.company.Company;

import java.util.List;

public class ServiceProviderCompanyDetails {
    private Company company;
    private List<TimeSlot> timeSlots;

    public ServiceProviderCompanyDetails(Company company, List<TimeSlot> timeSlots) {
        this.company = company;
        this.timeSlots = timeSlots;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}
