package com.indiacleantool.cleantool.datamodels.common.errormodels.exchange;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.indiacleantool.cleantool.datamodels.common.errormodels.Error;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> {

    private Error error;
    private T response;

    public GenericResponse(T response) {
        this.response = response;
    }

    public GenericResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
