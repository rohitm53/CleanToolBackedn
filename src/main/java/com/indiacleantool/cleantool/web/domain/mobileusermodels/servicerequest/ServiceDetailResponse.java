package com.indiacleantool.cleantool.web.domain.mobileusermodels.servicerequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.indiacleantool.cleantool.web.domain.errormodels.Error;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceDetailResponse {

    private ServiceDetailResponseBody serviceDetail;
    private Error error;

    public ServiceDetailResponse(ServiceDetailResponseBody serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public ServiceDetailResponse(Error error) {
        this.error = error;
    }

    public ServiceDetailResponseBody getServiceDetail() {
        return serviceDetail;
    }

    public void setServiceDetail(ServiceDetailResponseBody serviceDetail) {
        this.serviceDetail = serviceDetail;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}


