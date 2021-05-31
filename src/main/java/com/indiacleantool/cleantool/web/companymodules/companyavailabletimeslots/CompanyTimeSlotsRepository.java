package com.indiacleantool.cleantool.web.companymodules.companyavailabletimeslots;

import com.indiacleantool.cleantool.datamodels.companymodals.companytimeslots.CompanyTimeSlotsEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompanyTimeSlotsRepository extends CrudRepository<CompanyTimeSlotsEntity,Long> {

    long deleteByCompanyCodeAndDate(String companyCode , LocalDate date);

    List<CompanyTimeSlotsEntity> findByCompanyCodeAndDate(String companyCode , LocalDate date);

}
