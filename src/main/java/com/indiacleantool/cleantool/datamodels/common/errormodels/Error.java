package com.indiacleantool.cleantool.datamodels.common.errormodels;

public class Error {

    private String errormsg;


    public Error(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }
}
