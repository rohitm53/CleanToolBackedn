package com.indiacleantool.cleantool.web.modules.staticservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaticServicesService {

    @Autowired
    private StaticServiceRepository repository;
}
