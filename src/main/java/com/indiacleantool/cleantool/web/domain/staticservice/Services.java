package com.indiacleantool.cleantool.web.domain.staticservice;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Service code cannot be blank")
    @Size(min = 2 , max = 4 , message = "Please use 2 to 4 charaters for service code")
    @Column(updatable = false,unique = true)
    private String serviceCode;

    @NotBlank(message = "Service name cannot be blank")
    private String serviceName;

    private int noOfEmpReq;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date create_at;

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getNoOfEmpReq() {
        return noOfEmpReq;
    }

    public void setNoOfEmpReq(int noOfEmpReq) {
        this.noOfEmpReq = noOfEmpReq;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @PrePersist
    protected void onCreate(){
        this.create_at = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_at=new Date();
    }



}
