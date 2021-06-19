package com.indiacleantool.cleantool.datamodels.common.errormodels.exchange;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.indiacleantool.cleantool.datamodels.common.errormodels.Error;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {

    private T response;

    public GenericResponse(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
