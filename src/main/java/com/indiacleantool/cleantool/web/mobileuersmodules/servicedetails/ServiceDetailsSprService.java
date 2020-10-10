package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import com.indiacleantool.cleantool.web.domain.errormodels.Error;
import com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest.ServiceDetail;
import com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest.ServiceDetailResponse;
import com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest.ServiceDetailResponseBody;
import com.indiacleantool.cleantool.web.domain.users.company.Company;
import com.indiacleantool.cleantool.web.domain.users.company.CompanyCodeView;
import com.indiacleantool.cleantool.web.frontendmodules.companyservice.CompanyServiceSprService;
import com.indiacleantool.cleantool.web.frontendmodules.employeeservice.EmployeeServiceSprService;
import com.indiacleantool.cleantool.web.frontendmodules.users.company.CompanyService;
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



    public ServiceDetailResponse getServiceDetailsByServiceCode(String service_code){

        ServiceDetailResponse response =null;

        ///Step 1 , Get all company codes who provide service with provided service_code
        List<CompanyCodeView> companyCodeViewList = companyServiceSprService.getCompanyCodeByServiceCode(service_code);

        if (companyCodeViewList != null && companyCodeViewList.size()>0) {

            List<ServiceDetail> serviceDetailList = new ArrayList<>();

            for(CompanyCodeView companyCodeView : companyCodeViewList){

                ///Step 2 , Get all company deatails whose company codes got in step 1
                String companyCode = companyCodeView.getCompanyCode();
                Company company = companyService.findByCompanyCode(companyCode);

                ///Step 3 , Get all Employee codes whose company codes matches with
                // companycode of step 1 and provide service_code in order to get count of employees

                long count = employeeServiceSprService.countByCompanyCodeNServiceCode(companyCode,service_code);
                if(count>0){
                    serviceDetailList.add(new ServiceDetail(company,count));
                }
            }

            if(serviceDetailList.size()>0){
                ServiceDetailResponseBody responseBody = new ServiceDetailResponseBody(serviceDetailList);
                response = new ServiceDetailResponse(responseBody);
            }else{
                response = new ServiceDetailResponse(new Error("No free employees available"));
            }


        }else{
            response = new ServiceDetailResponse(new Error("No Company available"));
        }

        return response;
    }

}
