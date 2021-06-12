package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import com.indiacleantool.cleantool.web.companymodules.timeslots.TimeSlotsService;
import com.indiacleantool.cleantool.datamodels.common.errormodels.Error;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.serviceprovidercompany.ServiceProviderCompanyDetails;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.serviceprovidercompany.ServiceProviderDetailResponse;
import com.indiacleantool.cleantool.datamodels.users.company.Company;
import com.indiacleantool.cleantool.datamodels.users.company.CompanyCodeView;
import com.indiacleantool.cleantool.web.companymodules.companyservice.CompanyServiceSprService;
import com.indiacleantool.cleantool.web.companymodules.employeeservice.EmployeeServiceSprService;
import com.indiacleantool.cleantool.web.common.users.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDetailsSprService {

    @Autowired
    private CompanyServiceSprService companyServiceSprService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeServiceSprService employeeServiceSprService;


    @Autowired
    private TimeSlotsService timeSlotsService;


    public ServiceProviderDetailResponse getServiceDetailsByServiceCode(String service_code){

        ServiceProviderDetailResponse response =null;

        List<TimeSlot> timeSlotList = timeSlotsService.findAll();




        return response;
    }

}
