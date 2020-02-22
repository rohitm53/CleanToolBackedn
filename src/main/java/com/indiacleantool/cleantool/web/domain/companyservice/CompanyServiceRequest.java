package com.indiacleantool.cleantool.web.domain.companyservice;

import java.util.List;

public class CompanyServiceRequest {

   private String companyCode;
   private List<String> serviceCodes;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public List<String> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(List<String> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }
}