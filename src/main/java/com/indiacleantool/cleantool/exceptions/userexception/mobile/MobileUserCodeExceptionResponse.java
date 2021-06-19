package com.indiacleantool.cleantool.exceptions.userexception.mobile;

public class MobileUserCodeExceptionResponse {

    private String companyCode;

    public MobileUserCodeExceptionResponse() {
    }

    public MobileUserCodeExceptionResponse(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
