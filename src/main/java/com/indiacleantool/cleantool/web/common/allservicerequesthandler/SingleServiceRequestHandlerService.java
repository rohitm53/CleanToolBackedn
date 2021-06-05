package com.indiacleantool.cleantool.web.common.allservicerequesthandler;

import com.indiacleantool.cleantool.datamodels.common.errormodels.Error;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.companymodals.assignemployee.entity.EmployeeAssignedServiceEntity;
import com.indiacleantool.cleantool.datamodels.companymodals.assignemployee.exchange.AssignEmployeeRequest;
import com.indiacleantool.cleantool.datamodels.companymodals.assignemployee.exchange.AssignEmployeeResponse;
import com.indiacleantool.cleantool.datamodels.companymodals.companytimeslots.CompanyTimeSlotsEntity;
import com.indiacleantool.cleantool.datamodels.companymodals.staticservice.entity.Services;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.PendingServiceRequestResponse;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.ServiceReqResponse;
import com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest.ServiceRequestEntity;
import com.indiacleantool.cleantool.datamodels.users.company.Company;
import com.indiacleantool.cleantool.datamodels.users.employee.Employee;
import com.indiacleantool.cleantool.datamodels.users.mobileuser.MobileUser;
import com.indiacleantool.cleantool.exceptions.employeeservice.EmployeeServiceException;
import com.indiacleantool.cleantool.exceptions.servicecode.ServiceCodeException;
import com.indiacleantool.cleantool.exceptions.servicerequest.ServiceRequestException;
import com.indiacleantool.cleantool.exceptions.timeslots.TimeSlotCodeException;
import com.indiacleantool.cleantool.exceptions.userexception.company.CompanyCodeException;
import com.indiacleantool.cleantool.exceptions.userexception.employees.EmployeeCodeException;
import com.indiacleantool.cleantool.exceptions.userexception.mobile.MobileUserCodeException;
import com.indiacleantool.cleantool.web.companymodules.companyavailabletimeslots.CompanyTimeSlotsService;
import com.indiacleantool.cleantool.web.companymodules.timeslots.TimeSlotsService;
import com.indiacleantool.cleantool.web.common.users.company.CompanyService;
import com.indiacleantool.cleantool.web.common.users.mobileuser.MobileUserService;
import com.indiacleantool.cleantool.web.companymodules.employees.EmployeeSprService;
import com.indiacleantool.cleantool.web.companymodules.staticservices.StaticServicesService;
import com.indiacleantool.cleantool.web.mobileuersmodules.bookservicerequest.BookServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SingleServiceRequestHandlerService {

    @Autowired
    private BookServiceRepository repository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MobileUserService mobileUserService;

    @Autowired
    private EmployeeSprService employeeSprService;

    @Autowired
    private StaticServicesService servicesDataService;

    @Autowired
    private TimeSlotsService timeSlotsService;

    @Autowired
    private EmployeeAssignedServiceRepository employeeAssignedServiceRepository;

    @Autowired
    private CompanyTimeSlotsService companyTimeSlotsService;

    public ServiceReqResponse saveServiceRequest(ServiceRequestEntity request){

        ServiceReqResponse reqResponse = null;

        try{
            Company company = companyService.findByCompanyCode(request.getCompanyCode());
            MobileUser mobileUser = mobileUserService.findMobileUserByCode(request.getMobileUserCode());
            Services services = servicesDataService.findByServiceCode(request.getServiceCode());
            TimeSlot timeSlot = timeSlotsService.findBySlotCode(request.getTimeSlotCode());

            request.setCompany(company);
            request.setServices(services);
            request.setMobileUser(mobileUser);
            request.setTimeSlot(timeSlot);

            request.setStatusCode(ServiceRequestEntity.ServiceRequestStatus.PENDING.getStatusCode());

            ServiceRequestEntity savedServiceReq = repository.save(request);
            String serviceReqCode= repository.generateServiceRequestCode(savedServiceReq.getId());
            savedServiceReq.setServiceReqCode(serviceReqCode);


            reqResponse = new ServiceReqResponse(serviceReqCode,request.getStatusCode(),request.getScheduleDate());



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


    public PendingServiceRequestResponse getAllMobileServiceRequest(String mobileUserCode){

        PendingServiceRequestResponse response = null;

        try {
            List<ServiceRequestEntity> requestList = repository.findByMobileUserCodeIgnoreCase(mobileUserCode);
            if(requestList == null || requestList.size() == 0){
                throw new Exception("No Pending service");
            }

            requestList.forEach((serviceRequest -> {
                serviceRequest.setCompanyName(serviceRequest.getCompany().getCompanyName());

                if(serviceRequest.getAssignedEmployee()!=null){
                    serviceRequest.setAssignedEmployeeName(serviceRequest.getAssignedEmployee().getFirstName()
                            + " "+serviceRequest.getAssignedEmployee().getLastName());
                    serviceRequest.setAssignedEmployeeMobile(serviceRequest.getAssignedEmployee().getMobile());
                }

            }));

            response = new PendingServiceRequestResponse(requestList);

        }catch (Exception e){
            response = new PendingServiceRequestResponse(new Error(e.getMessage()));
        }

        return response;
    }


    public PendingServiceRequestResponse getAllCompanyServiceRequest(String companyCode){

        PendingServiceRequestResponse response = null;

        try{

            List<ServiceRequestEntity> requestList = repository.findByCompanyCodeIgnoreCase(companyCode);

            Map<String, Services> hmServices  = servicesDataService.getAllServiceDataInMap();

            if(requestList == null || requestList.size() == 0){
                throw new Exception("No Pending service");
            }

            requestList.forEach((serviceRequest -> {

                if(hmServices.containsKey(serviceRequest.getServiceCode())){
                    Services services = hmServices.get(serviceRequest.getServiceCode());
                    serviceRequest.setServiceName(services.getServiceName());
                }else{
                    serviceRequest.setServiceName("test name");
                }

                serviceRequest.setCompanyName(serviceRequest.getCompany().getCompanyName());
                serviceRequest.setScheduleTime(serviceRequest.getTimeSlot().getTime().toString());

                serviceRequest.setMobileUserName(serviceRequest.getMobileUser().getFirstName() + " " +
                        serviceRequest.getMobileUser().getLastName());

                if(serviceRequest.getAssignedEmployee()!=null){
                    serviceRequest.setAssignedEmployeeName(serviceRequest.getAssignedEmployee().getFirstName()
                            + " "+serviceRequest.getAssignedEmployee().getLastName());
                    serviceRequest.setAssignedEmployeeMobile(serviceRequest.getAssignedEmployee().getMobile());
                }

            }));

            requestList = requestList.stream()
                    .sorted(Comparator.comparing(ServiceRequestEntity::getScheduleDate)
                    .thenComparing(o -> o.getTimeSlot().getTime()))
                    .collect(Collectors.toList());

            response = new PendingServiceRequestResponse(requestList);

        }catch (Exception e){
            response = new PendingServiceRequestResponse(new Error(e.getMessage()));
        }
        return response;
    }


    @Transactional
    public AssignEmployeeResponse performAssignEmployeeToServiceReq(AssignEmployeeRequest request, String companyCode){
        AssignEmployeeResponse response = null;

        try{
            ServiceRequestEntity serviceRequestEntity = findByServiceReqCode(request.getServiceReqCode());
            Employee employee = employeeSprService.findByEmployeeCode(request.getAssignedEmployeeCode());



            List<Employee> employeeList = new ArrayList<>();

            employeeSprService.findAllByCompanyCode(companyCode).forEach(employeeList::add);

            if(employeeList==null){
                throw new EmployeeServiceException("Employee not available to assign service");
            }

            serviceRequestEntity.setAssignedEmployee(employee);
            serviceRequestEntity.setAssignedEmployeeCode(employee.getEmployeeCode());

            serviceRequestEntity.setStatusCode(ServiceRequestEntity.ServiceRequestStatus.ASSIGNED.getStatusCode());

            response = new AssignEmployeeResponse(
                    serviceRequestEntity.getServiceReqCode(),
                    serviceRequestEntity.getAssignedEmployeeCode(),
                    serviceRequestEntity.getStatusCode()
            );

            // Updating Table CompanyTimeSlots

            String scheduleTimeSlotCode = serviceRequestEntity.getTimeSlotCode();
            LocalDate scheduledDate = serviceRequestEntity.getScheduleDate();
            String scheduleTime = serviceRequestEntity.getScheduleTime();

            String nextTimeSlot = timeSlotsService.getNextTimeSlot(scheduleTimeSlotCode);
            String prevTimSlot  = timeSlotsService.getPreviousTimeSlot(scheduleTimeSlotCode);


            CompanyTimeSlotsEntity currentCompanyTimeSlot = companyTimeSlotsService.getByCompanyCodeNDateNTimeSlotCode(
                    companyCode,
                    scheduledDate.toString(),
                    scheduleTimeSlotCode
            );
            CompanyTimeSlotsEntity prevCompanyTimeSlot = companyTimeSlotsService.getByCompanyCodeNDateNTimeSlotCode(
                    companyCode,
                    scheduledDate.toString(),
                    prevTimSlot
            );
            CompanyTimeSlotsEntity nextCompanyTimeSlot = companyTimeSlotsService.getByCompanyCodeNDateNTimeSlotCode(
                    companyCode,
                    scheduledDate.toString(),
                    nextTimeSlot
            );

            int currentTimeSlotEmpCount,prevTimeSlotEmpCount=0,nextTimeSlotEmpCount=0;

            if(currentCompanyTimeSlot!=null){
                currentTimeSlotEmpCount = currentCompanyTimeSlot.getAvailableEmployeeCount();
                currentTimeSlotEmpCount--;

                if(currentTimeSlotEmpCount>-1){
                    currentCompanyTimeSlot.setAvailableEmployeeCount(currentTimeSlotEmpCount);
                    companyTimeSlotsService.saveCompanyTimeSlots(currentCompanyTimeSlot);
                }

            }

            if(nextCompanyTimeSlot!=null){
                nextTimeSlotEmpCount = nextCompanyTimeSlot.getAvailableEmployeeCount();
                nextTimeSlotEmpCount--;

                if(nextTimeSlotEmpCount>-1){
                    nextCompanyTimeSlot.setAvailableEmployeeCount(nextTimeSlotEmpCount);
                    companyTimeSlotsService.saveCompanyTimeSlots(nextCompanyTimeSlot);
                }

            }

            if(prevCompanyTimeSlot!=null){
                prevTimeSlotEmpCount = prevCompanyTimeSlot.getAvailableEmployeeCount();
                prevTimeSlotEmpCount--;
                if(prevTimeSlotEmpCount>-1){
                    prevCompanyTimeSlot.setAvailableEmployeeCount(prevTimeSlotEmpCount);
                    companyTimeSlotsService.saveCompanyTimeSlots(prevCompanyTimeSlot);
                }
            }

            //creating EmployeeAssignedServiceEntity for Keeping Employee duties track
            EmployeeAssignedServiceEntity employeeAssignedServiceEntity = new EmployeeAssignedServiceEntity();
            employeeAssignedServiceEntity.setServiceCode(serviceRequestEntity.getServiceCode());
            employeeAssignedServiceEntity.setCompanyCode(serviceRequestEntity.getCompanyCode());
            employeeAssignedServiceEntity.setEmpCode(serviceRequestEntity.getAssignedEmployeeCode());
            employeeAssignedServiceEntity.setScheduledDate(new Date());
            employeeAssignedServiceEntity.setTimeSlotCode(serviceRequestEntity.getTimeSlotCode());
            employeeAssignedServiceEntity.setMobileUserCode(serviceRequestEntity.getMobileUserCode());

            employeeAssignedServiceRepository.save(employeeAssignedServiceEntity);
        }
        catch (ServiceRequestException |
                EmployeeServiceException |
                EmployeeCodeException e){
            response = new AssignEmployeeResponse(new Error(e.getMessage()));
        }
        catch (Exception e){
            response = new AssignEmployeeResponse(new Error("Error while saving at backend"));
        }
        return response;
    }

    public ServiceRequestEntity findByServiceReqCode(String serviceReqCode)  {

        Optional<ServiceRequestEntity> serviceRequest = repository.findByServiceReqCode(serviceReqCode);
        if(serviceRequest.isPresent()){
            return serviceRequest.get();
        }else{
            throw  new ServiceRequestException("No Service available with serviceReqCode : "+serviceReqCode);
        }

    }


}
