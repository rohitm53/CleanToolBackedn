package com.indiacleantool.cleantool.web.common.bookservice;

import com.indiacleantool.cleantool.web.models.mobileusermodals.bookingservicerequest.ServiceRequest;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BookServiceRepository extends CrudRepository<ServiceRequest,Long> {

    @Procedure(name = "sp_Genarate_Service_RequestCode")
    String generateServiceRequestCode(@Param("service_req_id") Long id);


    List<ServiceRequest> findByMobileUserCodeIgnoreCase(String mobileUserCode);

    List<ServiceRequest> findByCompanyCodeIgnoreCase(String companyCode);

}
