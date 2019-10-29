package com.indiacleantool.cleantool.web.domain;

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

    @NotBlank(message = "Service Code cannot be blank")
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


    protected void onCreate(){
        this.create_at = new Date();
    }

    protected void onUpdate(){
        this.updated_at=new Date();
    }
}
