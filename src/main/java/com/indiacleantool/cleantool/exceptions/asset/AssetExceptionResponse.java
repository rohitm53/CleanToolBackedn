package com.indiacleantool.cleantool.exceptions.asset;

public class AssetExceptionResponse {

    private String code;

    public AssetExceptionResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
