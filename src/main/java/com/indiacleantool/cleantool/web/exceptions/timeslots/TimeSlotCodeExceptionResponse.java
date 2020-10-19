package com.indiacleantool.cleantool.web.exceptions.timeslots;

public class TimeSlotCodeExceptionResponse {

    private String code;

    public TimeSlotCodeExceptionResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
