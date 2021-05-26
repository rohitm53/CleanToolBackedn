package com.indiacleantool.cleantool.exceptions.userexception.company;

public class CompanyCodeExceptionResponse {

    private String companyCode;

    public CompanyCodeExceptionResponse() {
    }

    public CompanyCodeExceptionResponse(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
