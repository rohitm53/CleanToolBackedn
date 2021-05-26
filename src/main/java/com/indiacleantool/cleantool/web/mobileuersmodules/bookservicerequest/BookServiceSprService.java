package com.indiacleantool.cleantool.web.mobileuersmodules.bookservicerequest;

import com.indiacleantool.cleantool.web.common.allservicerequesthandler.SingleServiceRequestHandlerService;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.PendingServiceRequestResponse;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.ServiceReqResponse;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.ServiceRequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceSprService {

    @Autowired
    private SingleServiceRequestHandlerService singleServiceRequestHandlerService;


    public ServiceReqResponse saveServiceRequest(ServiceRequestEntity request){
        return singleServiceRequestHandlerService.saveServiceRequest(request);
    }


    public PendingServiceRequestResponse getAllMobileServiceRequest(String mobileUserCode){
        return singleServiceRequestHandlerService.getAllMobileServiceRequest(mobileUserCode);
    }



}
