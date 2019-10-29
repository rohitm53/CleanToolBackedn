package com.indiacleantool.cleantool.mobile.staticServices;

public class StaticService {

    private String serviceCode;
    private String serviceName;
    private String serviceDescription;
    private int noEmpReq;

    public StaticService() {
    }
    public StaticService(String serviceCode, String serviceName, String serviceDescription, int noEmpReq) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.noEmpReq = noEmpReq;
    }
    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getNoEmpReq() {
        return noEmpReq;
    }

    public void setNoEmpReq(int noEmpReq) {
        this.noEmpReq = noEmpReq;
    }
}
