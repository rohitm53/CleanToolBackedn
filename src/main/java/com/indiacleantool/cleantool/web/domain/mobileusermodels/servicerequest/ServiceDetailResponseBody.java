package com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest;

import java.util.List;

public class ServiceDetailResponseBody {

    private List<ServiceDetail> listServiceDetails;


    public ServiceDetailResponseBody(List<ServiceDetail> listServiceDetails) {
        this.listServiceDetails = listServiceDetails;
    }

    public List<ServiceDetail> getServiceDetails() {
        return listServiceDetails;
    }

    public void setServiceDetails(List<ServiceDetail> listServiceDetails) {
        this.listServiceDetails = listServiceDetails;
    }
}
