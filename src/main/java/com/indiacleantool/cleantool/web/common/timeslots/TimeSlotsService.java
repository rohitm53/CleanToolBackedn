package com.indiacleantool.cleantool.web.common.timeslots;

import com.indiacleantool.cleantool.web.exceptions.timeslots.TimeSlotCodeException;
import com.indiacleantool.cleantool.web.models.common.timeslots.TimeSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TimeSlotsService {

    @Autowired
    private TimeSlotsRepository repository;

    public List<TimeSlots> findAll(){
        List<TimeSlots> timeSlotsList = new ArrayList<>();
        repository.findAll().forEach(timeSlotsList::add);
        return timeSlotsList;
    }

    public TimeSlots findBySlotCode(String slotCode){
        TimeSlots timeSlots = repository.findBySlotCodeIgnoreCase(slotCode);

        if(timeSlots==null){
            throw new TimeSlotCodeException("No time slot avaible with code : "+slotCode);
        }
        return timeSlots ;
    }

}
