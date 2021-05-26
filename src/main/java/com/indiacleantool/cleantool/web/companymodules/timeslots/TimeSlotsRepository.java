package com.indiacleantool.cleantool.web.companymodules.timeslots;

import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlots;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotsRepository extends CrudRepository<TimeSlots,Long> {

    TimeSlots findBySlotCodeIgnoreCase(String slotCode);

    @Modifying
    @Query(value = "truncate table time_slots" , nativeQuery = true)
    void truncateTimeSlots();

}
