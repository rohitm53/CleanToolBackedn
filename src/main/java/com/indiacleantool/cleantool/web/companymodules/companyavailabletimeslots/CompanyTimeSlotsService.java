package com.indiacleantool.cleantool.web.companymodules.companyavailabletimeslots;

import com.indiacleantool.cleantool.common.collectionUtils.ListUtils;
import com.indiacleantool.cleantool.datamodels.common.errormodels.exchange.GenericResponse;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.companymodals.companytimeslots.CompanyTimeSlotsEntity;
import com.indiacleantool.cleantool.datamodels.companymodals.companytimeslots.exchange.GenerateCompanyTimeSlotRequest;
import com.indiacleantool.cleantool.datamodels.users.company.Company;
import com.indiacleantool.cleantool.exceptions.common.CommonGenericException;
import com.indiacleantool.cleantool.web.common.users.company.CompanyService;
import com.indiacleantool.cleantool.web.companymodules.employees.EmployeeSprService;
import com.indiacleantool.cleantool.web.companymodules.timeslots.TimeSlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyTimeSlotsService {

    @Autowired
    private CompanyTimeSlotsRepository repository;

    @Autowired
    private TimeSlotsService timeSlotsService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeSprService employeeSprService;



    public CompanyTimeSlotsEntity saveCompanyTimeSlots(CompanyTimeSlotsEntity companyTimeSlotsEntity){
        return repository.save(companyTimeSlotsEntity);
    }

    @Transactional
    public GenericResponse generateTimeSlots(GenerateCompanyTimeSlotRequest request, String companyCode) {

        GenericResponse response;

        try{

            LocalDate currentDate = LocalDate.parse(request.getCurrentDate());
            LocalTime starTime = LocalTime.parse(request.getStartTime());
            LocalTime endTime = LocalTime.parse(request.getEndTime());

            Company company = companyService.findByCompanyCode(companyCode);

            int employeeCount = employeeSprService
                                .getCountByCompanyCode(company.getCompanyCode())
                                .intValue();

            companyCode = company.getCompanyCode();

            List<TimeSlot> availableSlots = timeSlotsService.getTimeSlotByStartNEndTime(
                    starTime.toString(),
                    endTime.toString()
            );

            if(availableSlots==null || availableSlots.size()==0){
                response = new GenericResponse<>(
                        "No Static time slots available"
                );
            }else if(employeeCount==0){
                response = new GenericResponse<>(
                        "No Employee available for company : "+companyCode
                );
            }else{
                List<CompanyTimeSlotsEntity> companyTimeSlots = new ArrayList<>();
                for(TimeSlot timeSlot : availableSlots){
                    companyTimeSlots.add(new CompanyTimeSlotsEntity(
                            companyCode,
                            timeSlot.getSlotCode(),
                            currentDate,
                            timeSlot.getTime(),
                            employeeCount
                    ));
                }
               repository.deleteByCompanyCodeAndDate(companyCode,currentDate);
               Iterable<CompanyTimeSlotsEntity> iterable = repository.saveAll(companyTimeSlots);

               List<CompanyTimeSlotsEntity> result = ListUtils.convertIterableToStream(iterable).collect(Collectors.toList());
               response = new GenericResponse<>(result);
            }
        }catch (Exception e){
            if(e instanceof DateTimeParseException){
                throw new CommonGenericException("Invalid date/time");
            }else{
                throw new CommonGenericException("SQL Exception");
            }
        }
        return response;
    }

    public List<CompanyTimeSlotsEntity> getAllCompanyAvailableTimeSlotsByDate(
            String company_code,
            String date
    ){
        try{
            return repository.findByCompanyCodeAndDate(company_code,LocalDate.parse(date));
        }catch (Exception e){
            throw new CommonGenericException("Invalid date");
        }

    }

    public CompanyTimeSlotsEntity getByCompanyCodeNDateNTimeSlotCode(String companyCode , String date , String timeSlotCode){
        return repository.getByCompanyCodeNDateNTimeSlotCode(companyCode,date,timeSlotCode);
    }
}
