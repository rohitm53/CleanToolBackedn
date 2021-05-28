package com.indiacleantool.cleantool.web.companymodules.timeslots;

import com.indiacleantool.cleantool.exceptions.timeslots.TimeSlotCodeException;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
            throw new TimeSlotCodeException("No time slot available with code : "+slotCode);
        }
        return timeSlots ;
    }

    @Transactional
    public void generateTimeSlots() {

        List<TimeSlots> timeSlotsList = new ArrayList<>();

        LocalTime localTime  = LocalTime.of(8,0);
        for(int i=1; i<=24;i++){
            timeSlotsList.add(new TimeSlots("T"+i,localTime));
            localTime  = localTime.plusHours(1);
        }
        repository.truncateTimeSlots();
        repository.saveAll(timeSlotsList);

    }
}
