package com.indiacleantool.cleantool.web.companymodules.assignemployee;

import com.indiacleantool.cleantool.datamodels.companymodals.assignemployee.exchange.AssignEmployeeRequest;
import com.indiacleantool.cleantool.datamodels.companymodals.assignemployee.exchange.AssignEmployeeResponse;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.PendingServiceRequestResponse;
import com.indiacleantool.cleantool.web.common.allservicerequesthandler.SingleServiceRequestHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignEmployeeService {

    @Autowired
    private SingleServiceRequestHandlerService singleServiceRequestHandlerService;

    public PendingServiceRequestResponse getAllCompanyServiceRequest(String companyCode){
        return singleServiceRequestHandlerService.getAllCompanyServiceRequest(companyCode);
    }

    public AssignEmployeeResponse performAssignEmployeeToServiceReq(AssignEmployeeRequest request, String companyCode){
        return singleServiceRequestHandlerService.performAssignEmployeeToServiceReq(request,companyCode);
    }


}
