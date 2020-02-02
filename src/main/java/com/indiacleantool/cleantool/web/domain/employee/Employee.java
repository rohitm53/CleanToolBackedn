package com.indiacleantool.cleantool.web.domain.employee;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name="generateEmployeeCode",
                                   procedureName = "generateEmployeeCode",
                                   parameters = {
                                        @StoredProcedureParameter(mode = ParameterMode.IN,name="empId",type = Long.class),
                                        @StoredProcedureParameter(mode = ParameterMode.OUT,name="empCode",type = String.class)
                                   })
})
public class Employee  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;

    @NotBlank(message = "Select gender")
    private String gender;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "Select date of birth")
    private Date dateOfBirth;

    @NotBlank(message = "Mobile number cannot be blank")
    @Size(min = 10,max = 10,message = "Mobile number should be 10 digits")
    private String mobile;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Area of working cannot be blank")
    private String area;

    @NotBlank(message = "Adress cannot be blank")
    private String address;

    private String employeeCode;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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


}