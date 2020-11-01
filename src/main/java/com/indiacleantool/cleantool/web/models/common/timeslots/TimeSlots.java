package com.indiacleantool.cleantool.web.models.common.timeslots;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.indiacleantool.cleantool.common.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class TimeSlots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.APP_LEVEL_DATE_FORMAT , locale = "en")
    private Date time;

    public TimeSlots() {
    }

    public TimeSlots(Long id, String slotCode, Date time) {
        this.id = id;
        this.slotCode = slotCode;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlotCode() {
        return slotCode;
    }

    public void setSlotCode(String slotCode) {
        this.slotCode = slotCode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}