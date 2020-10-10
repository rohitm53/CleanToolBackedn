package com.indiacleantool.cleantool.web.frontendmodules.staticservices;

import com.indiacleantool.cleantool.web.domain.staticservice.Services;
import com.indiacleantool.cleantool.web.exceptions.servicecode.ServiceCodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticServicesService {

    @Autowired
    private StaticServiceRepository repository;

    public Services saveOrUpdateService(Services service){
        try{
            service.setServiceCode(service.getServiceCode().toUpperCase());
            return repository.save(service);
        }catch (Exception e){
            throw new ServiceCodeException("Service code '"+service.getServiceCode()+"' already existed ");
        }
    }

    public Iterable<Services> findAllServices(){
        return repository.findAll();
    }

    public Services findByServiceCode(String serviceCode){
        Services services = repository.findByServiceCode(serviceCode.toUpperCase());
        if(services==null){
            throw new ServiceCodeException("No Service available with code '"+serviceCode+"'.");
        }
        return services;
    }

    public void deleteService(String serviceCode){
        repository.delete(findByServiceCode(serviceCode));
    }
}
