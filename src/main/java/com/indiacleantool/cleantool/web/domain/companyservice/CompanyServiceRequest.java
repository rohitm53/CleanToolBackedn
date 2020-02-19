package com.indiacleantool.cleantool.web.domain.companyservice;

import java.util.List;

public class CompanyServiceRequest {

    private List<CompanyService> listCompanyServices;

    public List<CompanyService> getListCompanyServices() {
        return listCompanyServices;
    }

    public void setListCompanyServices(List<CompanyService> listCompanyServices) {
        this.listCompanyServices = listCompanyServices;
    }
}
