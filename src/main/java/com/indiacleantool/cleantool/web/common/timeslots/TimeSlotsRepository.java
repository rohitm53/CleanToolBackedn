package com.indiacleantool.cleantool.web.common.timeslots;

import com.indiacleantool.cleantool.web.models.common.timeslots.TimeSlots;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotsRepository extends CrudRepository<TimeSlots,Long> {

    TimeSlots findBySlotCodeIgnoreCase(String slotCode);

}
