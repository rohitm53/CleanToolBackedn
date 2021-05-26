package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import com.indiacleantool.cleantool.web.companymodules.timeslots.TimeSlotsService;
import com.indiacleantool.cleantool.datamodels.common.errormodels.Error;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlots;
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

        List<TimeSlots> timeSlotsList = timeSlotsService.findAll();

        ///Step 1 , Get all company codes who provide service with provided service_code
        List<CompanyCodeView> companyCodeViewList = companyServiceSprService.getCompanyCodeByServiceCode(service_code);

        if (companyCodeViewList != null && companyCodeViewList.size()>0) {

            List<ServiceProviderCompanyDetails> lisServiceProviderCompanyDetails = new ArrayList<>();

            for(CompanyCodeView companyCodeView : companyCodeViewList){

                ///Step 2 , Get all company details whose company codes got in step 1
                String companyCode = companyCodeView.getCompanyCode();
                Company company = companyService.findByCompanyCode(companyCode);

                ///Step 3 , Get all Employee codes whose company codes matches with
                // companyCode of step 1 and provide service_code in order to get count of employees

                long count = employeeServiceSprService.countByCompanyCode(companyCode);
                if(count>0){
                    lisServiceProviderCompanyDetails.add(new ServiceProviderCompanyDetails(company,count,timeSlotsList));
                }
            }

            if(lisServiceProviderCompanyDetails.size()>0){
                response = new ServiceProviderDetailResponse(lisServiceProviderCompanyDetails);
            }else{
                response = new ServiceProviderDetailResponse(new Error("No free employees available"));
            }
        }else{
            response = new ServiceProviderDetailResponse(new Error("No Company available"));
        }

        return response;
    }

//    private List<TimeSlots> getTimeSlots(){
//
//        int startTimeHour = 8;
//        List<TimeSlots> listTimeSlots = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.MONTH,1);
//        calendar.set(Calendar.DAY_OF_MONTH,1);
//        calendar.set(Calendar.YEAR,1990);
//
//        calendar.set(Calendar.HOUR_OF_DAY,startTimeHour);
//        calendar.set(Calendar.MINUTE,0);
//        calendar.set(Calendar.SECOND,0);
//
//
//        for(int i=1;i<=8;i++){
//            String code = "T"+i;
//            Date date = calendar.getTime();
//            listTimeSlots.add(new TimeSlots((long) i,code,date));
//            startTimeHour++;
//            calendar.set(Calendar.HOUR_OF_DAY,startTimeHour);
//        }
//
//        return listTimeSlots;
//    }

}
