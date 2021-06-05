package com.indiacleantool.cleantool.web.companymodules.timeslots;

import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotsRepository extends CrudRepository<TimeSlot,Long> {

    TimeSlot findBySlotCodeIgnoreCase(String slotCode);

    @Modifying
    @Query(value = "truncate table time_slot" , nativeQuery = true)
    void truncateTimeSlots();

    @Query(value = "select * from time_slot where time(slot_time) " +
            " between cast(:startTime as time) and cast(:endTime as time) " +
            " order by slot_time asc " ,nativeQuery = true)
    List<TimeSlot> getTimeSlotByStartNEndTime(
            @Param("startTime") String startTime ,
            @Param("endTime") String endTime
    );


}
