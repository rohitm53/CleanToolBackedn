package com.indiacleantool.cleantool.web.exceptions.servicecode;

public class ServiceCodeExceptionResponse {

    private String serviceCode;

    public ServiceCodeExceptionResponse(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
