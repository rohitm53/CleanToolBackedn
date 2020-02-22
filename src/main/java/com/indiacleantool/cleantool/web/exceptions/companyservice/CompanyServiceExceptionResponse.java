package com.indiacleantool.cleantool.web.exceptions.companyservice;

public class CompanyServiceExceptionResponse {

    private String error;

    public CompanyServiceExceptionResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
