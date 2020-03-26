package com.indiacleantool.cleantool.web.exceptions.asset;

public class AssetExceptionResponse {

    private String error;

    public AssetExceptionResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
