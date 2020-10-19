package com.indiacleantool.cleantool.web.common.bookservice;

import com.indiacleantool.cleantool.web.common.timeslots.TimeSlotsService;
import com.indiacleantool.cleantool.web.exceptions.servicecode.ServiceCodeException;
import com.indiacleantool.cleantool.web.exceptions.timeslots.TimeSlotCodeException;
import com.indiacleantool.cleantool.web.exceptions.userexception.company.CompanyCodeException;
import com.indiacleantool.cleantool.web.exceptions.userexception.mobile.MobileUserCodeException;
import com.indiacleantool.cleantool.web.frontendmodules.employees.EmployeeService;
import com.indiacleantool.cleantool.web.frontendmodules.staticservices.StaticServicesService;
import com.indiacleantool.cleantool.web.frontendmodules.users.company.CompanyService;
import com.indiacleantool.cleantool.web.frontendmodules.users.mobileuser.MobileUserService;
import com.indiacleantool.cleantool.web.models.common.errormodels.Error;
import com.indiacleantool.cleantool.web.models.common.timeslots.TimeSlots;
import com.indiacleantool.cleantool.web.models.frontendmodals.staticservice.Services;
import com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest.ServiceReqResponse;
import com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest.ServiceRequest;
import com.indiacleantool.cleantool.web.models.users.company.Company;
import com.indiacleantool.cleantool.web.models.users.mobileuser.MobileUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.TimeoutException;

@Service
public class BookServiceSprService {

    @Autowired
    private BookServiceRepository repository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MobileUserService mobileUserService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StaticServicesService servicesService;

    @Autowired
    private TimeSlotsService timeSlotsService;

    public ServiceReqResponse saveServiceRequest(ServiceRequest request){

        ServiceReqResponse reqResponse = null;

        try{
            Company company = companyService.findByCompanyCode(request.getCompanyCode());
            MobileUser mobileUser = mobileUserService.findMobileUserByCode(request.getMobileUserCode());
            Services services = servicesService.findByServiceCode(request.getServiceCode());
            TimeSlots timeSlots = timeSlotsService.findBySlotCode(request.getTimeSlotCode());

            request.setCompany(company);
            request.setServices(services);
            request.setMobileUser(mobileUser);
            request.setTimeSlots(timeSlots);

            request.setStatusCode(ServiceRequest.ServiceRequestStatus.PENDING.getStatusCode());
            request.setStatusName(ServiceRequest.ServiceRequestStatus.PENDING.getStatusName());


            ServiceRequest savedServiceReq = repository.save(request);
            String serviceReqCode= repository.generateServiceRequestCode(savedServiceReq.getId());
            savedServiceReq.setServiceReqCode(serviceReqCode);


            reqResponse = new ServiceReqResponse(serviceReqCode,request.getStatusCode(),request.getStatusName(),timeSlots.getTime());



        }
        catch (CompanyCodeException e){
            reqResponse = new ServiceReqResponse(new Error("Invalid company code."));
        }
        catch (MobileUserCodeException e){
            reqResponse = new ServiceReqResponse(new Error("Invalid Mobile user code."));
        }
        catch (ServiceCodeException e){
            reqResponse = new ServiceReqResponse(new Error("Invalid selected service code."));
        }
        catch (TimeSlotCodeException e){
            reqResponse = new ServiceReqResponse(new Error("Invalid time slot code selected."));
        }
        catch (Exception e){
            reqResponse = new ServiceReqResponse(new Error("Error while saving at backend"));
        }

        return reqResponse;
    }

}
