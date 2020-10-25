package com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.indiacleantool.cleantool.web.models.common.errormodels.Error;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PendingServiceRequestResponse {

    @JsonProperty("serviceRequests")
    private List<ServiceRequest> listServiceRequest;
    private Error error;


    public PendingServiceRequestResponse() {
    }

    public PendingServiceRequestResponse(List<ServiceRequest> listServiceRequest) {
        this.listServiceRequest = listServiceRequest;
    }

    public PendingServiceRequestResponse(Error error) {
        this.error = error;
    }

    public List<ServiceRequest> getListServiceRequest() {
        return listServiceRequest;
    }

    public void setListServiceRequest(List<ServiceRequest> listServiceRequest) {
        this.listServiceRequest = listServiceRequest;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
