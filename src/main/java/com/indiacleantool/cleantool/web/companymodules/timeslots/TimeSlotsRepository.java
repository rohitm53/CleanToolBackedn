package com.indiacleantool.cleantool.web.companymodules.timeslots;

import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlots;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface TimeSlotsRepository extends CrudRepository<TimeSlots,Long> {

    TimeSlots findBySlotCodeIgnoreCase(String slotCode);

    @Modifying
    @Query(value = "truncate table time_slots" , nativeQuery = true)
    void truncateTimeSlots();

    @Query(value = "select * from time_slots where time(slot_time) " +
            " between cast(:startTime as time) and cast(:endTime as time) " +
            " order by slot_time asc " ,nativeQuery = true)
    List<TimeSlots> getTimeSlotByStartNEndTime(
            @Param("startTime") String startTime ,
            @Param("endTime") String endTime
    );


}
