package com.indiacleantool.cleantool.exceptions.servicecode;

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
