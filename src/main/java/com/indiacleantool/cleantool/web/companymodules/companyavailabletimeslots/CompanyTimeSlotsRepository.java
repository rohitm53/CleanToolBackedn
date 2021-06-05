package com.indiacleantool.cleantool.web.companymodules.companyavailabletimeslots;

import com.indiacleantool.cleantool.datamodels.companymodals.companytimeslots.CompanyTimeSlotsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompanyTimeSlotsRepository extends CrudRepository<CompanyTimeSlotsEntity,Long> {

    long deleteByCompanyCodeAndDate(String companyCode , LocalDate date);

    List<CompanyTimeSlotsEntity> findByCompanyCodeAndDate(String companyCode , LocalDate date);

    @Query(
            value = "select * from company_time_slots where company_code = :companyCode" +
                    " and date= :date and time_slot_code = :timeSlotCode",
            nativeQuery = true
    )
    CompanyTimeSlotsEntity getByCompanyCodeNDateNTimeSlotCode(String companyCode , String date , String timeSlotCode);

}
