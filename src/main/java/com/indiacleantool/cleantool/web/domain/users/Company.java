package com.indiacleantool.cleantool.web.domain.users;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company_user")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company code cannot be blank")
    @Size(min = 2 , max = 6 , message = "Please use 2 to 6 charaters for company code")
    @Column(updatable = false,unique = true)
    private String companyCode;

    @NotBlank(message = "Company name cannot be blank")
    private String companyName;

    @NotBlank(message = "Company address cannot be blank")
    private String address;

    @NotBlank(message = "Company email cannot be blank")
    private String email;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "company")
    private UserCredentials userCredentials;

    public Company() {
    }

    public Company(long id, String companyCode, String companyName, String address, String email) {
        this.id = id;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }
}
