package com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.indiacleantool.cleantool.common.Constants;
import com.indiacleantool.cleantool.web.models.common.errormodels.Error;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceReqResponse {

    private String serviceReqCode;
    private int statusCode;
    private String statusName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.APP_LEVEL_DATE_FORMAT , locale = "en")
    private Date scheduled;

    private Error error;

    public ServiceReqResponse(String serviceReqCode, int statusCode, String statusName, Date scheduled) {
        this.serviceReqCode = serviceReqCode;
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.scheduled = scheduled;
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

    public Date getScheduled() {
        return scheduled;
    }

    public void setScheduled(Date scheduled) {
        this.scheduled = scheduled;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
