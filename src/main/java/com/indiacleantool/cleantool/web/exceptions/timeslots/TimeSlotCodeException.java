package com.indiacleantool.cleantool.web.exceptions.timeslots;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimeSlotCodeException extends RuntimeException {

    public TimeSlotCodeException(String message) {
        super(message);
    }
}
