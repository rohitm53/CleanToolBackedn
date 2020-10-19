package com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.indiacleantool.cleantool.web.models.common.errormodels.Error;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceReqResponse {

    private String serviceReqCode;
    private int statusCode;
    private String statusName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date time;

    private Error error;

    public ServiceReqResponse(String serviceReqCode, int statusCode, String statusName, Date time) {
        this.serviceReqCode = serviceReqCode;
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.time = time;
    }

    public ServiceReqResponse(Error error) {
        this.error = error;
    }

    public String getServiceReqCode() {
        return serviceReqCode;
    }

    public void setServiceReqCode(String serviceReqCode) {
        this.serviceReqCode = serviceReqCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
