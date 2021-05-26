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

    private LocalTime time;

    public TimeSlots() {
    }

    public TimeSlots(Long id, String slotCode, LocalTime time) {
        this.id = id;
        this.slotCode = slotCode;
        this.time = time;
    }

    public TimeSlots(String slotCode, LocalTime time) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}