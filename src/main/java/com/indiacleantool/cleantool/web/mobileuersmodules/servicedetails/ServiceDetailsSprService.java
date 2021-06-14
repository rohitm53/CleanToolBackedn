package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import com.indiacleantool.cleantool.datamodels.users.employee.Employee;
import com.indiacleantool.cleantool.exceptions.common.CommonGenericException;
import com.indiacleantool.cleantool.web.companymodules.employees.EmployeeSprService;
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
    private ServiceDetailsDao serviceDetailsDao;



    public ServiceProviderDetailResponse getServiceProviderCompanyList(String serviceCode , String date){

        ServiceProviderDetailResponse response =null;

        try{
            List<Company> companyList = serviceDetailsDao.getAvailableCompanyByServiceCode(serviceCode);
            List<ServiceProviderCompanyDetails> listServiceProviderCompanyDetails = new ArrayList<>();
            for(Company company : companyList){

                List<TimeSlot> timeSlotList = serviceDetailsDao.getAvailableTimeSlots(company.getCompanyCode(),date);
                    ServiceProviderCompanyDetails serviceProviderCompanyDetails = new ServiceProviderCompanyDetails(
                            company,
                            !(timeSlotList==null || timeSlotList.size()==0) ? timeSlotList : new ArrayList<>()
                    );
                    listServiceProviderCompanyDetails.add(serviceProviderCompanyDetails);
            }
            response = new ServiceProviderDetailResponse(listServiceProviderCompanyDetails);

        }catch (Exception e){
            e.printStackTrace();
            throw new CommonGenericException("No Data Available");
        }

        return response;
    }

}
