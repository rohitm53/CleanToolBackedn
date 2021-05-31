package com.indiacleantool.cleantool.datamodels.common.timeslots;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.indiacleantool.cleantool.common.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;


@Entity
public class TimeSlots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotCode;

    private LocalTime slotTime;

    public TimeSlots() {
    }

    public TimeSlots(Long id, String slotCode, LocalTime slotTime) {
        this.id = id;
        this.slotCode = slotCode;
        this.slotTime = slotTime;
    }

    public TimeSlots(String slotCode, LocalTime slotTime) {
        this.slotCode = slotCode;
        this.slotTime = slotTime;
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

    public LocalTime getTime() {
        return slotTime;
    }

    public void setTime(LocalTime slotTime) {
        this.slotTime = slotTime;
    }
}