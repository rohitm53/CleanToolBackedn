package com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.indiacleantool.cleantool.web.models.common.timeslots.TimeSlots;
import com.indiacleantool.cleantool.web.models.frontendmodals.staticservice.Services;
import com.indiacleantool.cleantool.web.models.users.company.Company;
import com.indiacleantool.cleantool.web.models.users.employee.Employee;
import com.indiacleantool.cleantool.web.models.users.mobileuser.MobileUser;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Service code cannot be blank")
    private String serviceCode;

    @NotBlank(message = "Company code cannot be blank")
    private String companyCode;

    @NotBlank(message = "Mobile user code cannot be blank")
    private String mobileUserCode;

    @NotBlank(message = "Time slot code cannot be blank")
    private String timeSlotCode;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlots timeSlots;

    @ManyToOne
    @JoinColumn(name = "mobile_user_id")
    private MobileUser mobileUser;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private  int statusCode;  //Should be assigned by Inner ServiceRequestStatus Enum Class

    private  String statusName;  //Should be assigned by Inner ServiceRequestStatus Enum Class

    private Double reqLatitude;

    private Double reqLongitude;


    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_at;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_at;


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

    public TimeSlots getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(TimeSlots timeSlots) {
        this.timeSlots = timeSlots;
    }

    public Double getReqLatitude() {
        return reqLatitude;
    }

    public void setReqLatitude(Double reqLatitude) {
        this.reqLatitude = reqLatitude;
    }

    public Double getReqLongitude() {
        return reqLongitude;
    }

    public void setReqLongitude(Double reqLongitude) {
        this.reqLongitude = reqLongitude;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
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
        PENDING(1,"Pending"),
        ASSIGNED(2,"Assigned"),
        INPROGRESS(3,"In-Progress"),
        COMPLETED(4,"COMPLETED");

        private final int statusCode;
        private final String statusName;
        ServiceRequestStatus(int statusCode, String statusName) {
            this.statusCode=statusCode;
            this.statusName=statusName;
        }

    }

}
