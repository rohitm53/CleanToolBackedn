package com.indiacleantool.cleantool.datamodels.common.errormodels;

public class Error {

    private String errorMsg;


    public Error(String errormsg) {
        this.errorMsg = errormsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
