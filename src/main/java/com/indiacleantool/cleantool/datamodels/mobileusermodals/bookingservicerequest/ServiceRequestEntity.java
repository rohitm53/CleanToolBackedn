package com.indiacleantool.cleantool.datamodels.mobileusermodals.bookingservicerequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.companymodals.staticservice.entity.Services;
import com.indiacleantool.cleantool.datamodels.users.company.Company;
import com.indiacleantool.cleantool.datamodels.users.employee.Employee;
import com.indiacleantool.cleantool.datamodels.users.mobileuser.MobileUser;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "ServiceRequest")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_Generate_Service_RequestCode",
                procedureName = "sp_Generate_Service_RequestCode",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN,name = "service_req_id",type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT,name = "service_req_code",type = String.class)
                }
        )
})
public class ServiceRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Service code cannot be blank")
    private String serviceCode;

    @NotBlank(message = "Company code cannot be blank")
    private String companyCode;

    @NotBlank(message = "Mobile user code cannot be blank")
    private String mobileUserCode;

    @NotNull(message = "Scheduled date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]",shape=JsonFormat.Shape.STRING)
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate scheduleDate;

    @NotBlank(message = "Time slot code cannot be blank")
    private String timeSlotCode;

    @NotBlank(message = "Service message id cannot be blank")
    private String serviceMsgId;

    private String assignedEmployeeCode;

    private  int statusCode;  //Should be assigned by Inner ServiceRequestStatus Enum Class

    private String serviceReqCode;  // Need to generated by running Stored procedure


    ///Mapping objects only used for generating mapping with other tables

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    @JsonIgnore
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "mobile_user_id")
    @JsonIgnore
    private MobileUser mobileUser;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @JsonIgnore
    private Services services;

    @OneToOne
    @JoinColumn(name = "assigned_employee_id")
    @JsonIgnore
    private Employee assignedEmployee;


    ////Transient objects Only for Frontend and Mobile user request/response
    @Transient
    private String scheduleTime;

    @Transient
    private String companyName;

    @Transient
    private String mobileUserName;

    @Transient
    private String serviceName;

    @Transient
    private String assignedEmployeeName;

    @Transient
    private String assignedEmployeeMobile;


    ///Pre and Post Persist

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_at;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_at;


    ///Getters and Setters

    public String getAssignedEmployeeCode() {
        return assignedEmployeeCode;
    }

    public void setAssignedEmployeeCode(String assignedEmployeeCode) {
        this.assignedEmployeeCode = assignedEmployeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getMobileUserCode() {
        return mobileUserCode;
    }

    public void setMobileUserCode(String mobileUserCode) {
        this.mobileUserCode = mobileUserCode;
    }

    public String getTimeSlotCode() {
        return timeSlotCode;
    }

    public void setTimeSlotCode(String timeSlotCode) {
        this.timeSlotCode = timeSlotCode;
    }

    public String getServiceMsgId() {
        return serviceMsgId;
    }

    public void setServiceMsgId(String serviceMsgId) {
        this.serviceMsgId = serviceMsgId;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public MobileUser getMobileUser() {
        return mobileUser;
    }

    public void setMobileUser(MobileUser mobileUser) {
        this.mobileUser = mobileUser;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getServiceReqCode() {
        return serviceReqCode;
    }

    public void setServiceReqCode(String serviceReqCode) {
        this.serviceReqCode = serviceReqCode;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAssignedEmployeeName() {
        return assignedEmployeeName;
    }

    public void setAssignedEmployeeName(String assignedEmployeeName) {
        this.assignedEmployeeName = assignedEmployeeName;
    }

    public String getAssignedEmployeeMobile() {
        return assignedEmployeeMobile;
    }

    public void setAssignedEmployeeMobile(String assignedEmployeeMobile) {
        this.assignedEmployeeMobile = assignedEmployeeMobile;
    }

    public String getMobileUserName() {
        return mobileUserName;
    }

    public void setMobileUserName(String mobileUserName) {
        this.mobileUserName = mobileUserName;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @PrePersist
    protected void onCreate(){
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_at=new Date();
    }


    public enum ServiceRequestStatus {
        PENDING(100,"Pending"),
        ASSIGNED(101,"Assigned"),
        INPROGRESS(102,"In-Progress"),
        COMPLETED(103,"Completed"),
        CANCELED(104,"Canceled");

        private final int statusCode;
        private final String statusName;
        ServiceRequestStatus(int statusCode, String statusName) {
            this.statusCode=statusCode;
            this.statusName=statusName;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getStatusName() {
            return statusName;
        }
    }

}
