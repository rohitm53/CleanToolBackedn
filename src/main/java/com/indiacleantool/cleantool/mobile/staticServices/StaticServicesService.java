package com.indiacleantool.cleantool.mobile.staticServices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaticServicesService {

    public List<StaticService> getALlServices(){
        List<StaticService> listService = new ArrayList<>();

        StaticService staticService = new StaticService();
        staticService.setServiceCode("HC");
        staticService.setServiceName("House Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("House Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("OC");
        staticService.setServiceName("Office Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("Office Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("APC");
        staticService.setServiceName("After Party Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("After Party Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("MIC");
        staticService.setServiceName("Move In Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("Move In Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("MOC");
        staticService.setServiceName("Move out Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("Move out Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("BC");
        staticService.setServiceName("Basic Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("Basic Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("CC");
        staticService.setServiceName("Carpet Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("Carpet Cleaning");

        listService.add(staticService);

        staticService = new StaticService();
        staticService.setServiceCode("CLC");
        staticService.setServiceName("Cloths Cleaning");
        staticService.setNoEmpReq(1);
        staticService.setServiceDescription("Cloths Cleaning");

        listService.add(staticService);

        return  listService;
    }
}
