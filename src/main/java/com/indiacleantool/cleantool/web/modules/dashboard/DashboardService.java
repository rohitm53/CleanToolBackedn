package com.indiacleantool.cleantool.web.modules.dashboard;

import com.indiacleantool.cleantool.web.domain.assets.Asset;
import com.indiacleantool.cleantool.web.domain.companydashboard.DashboardReportResponse;
import com.indiacleantool.cleantool.web.domain.companyservice.CompanyService;
import com.indiacleantool.cleantool.web.domain.employee.Employee;
import com.indiacleantool.cleantool.web.domain.staticservice.Services;
import com.indiacleantool.cleantool.web.modules.asset.AssetService;
import com.indiacleantool.cleantool.web.modules.companyservice.CompanyServiceSprService;
import com.indiacleantool.cleantool.web.modules.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AssetService assetService;

    @Autowired
    private CompanyServiceSprService companyServiceSprService;

    public DashboardReportResponse getInitialDashboarReport(String compnayCode){
        Iterable<Services> iterableService  =  companyServiceSprService.getServicesForCompanybyCompanyCode(compnayCode);
        Iterable<Employee> iterableEmployee =  employeeService.findAllByCompanyCode(compnayCode);
        Iterable<Asset> iterableAssets      =  assetService.getAllAssetsByCompanyCode(compnayCode);
        int serviceCount=0,employeeCount=0,assetCount=0;

        for(Services services : iterableService){
            serviceCount++;
        }
        for(Employee employee : iterableEmployee){
            employeeCount++;
        }
        for(Asset asset : iterableAssets){
            assetCount++;
        }

        DashboardReportResponse dashboardReportResponse = new DashboardReportResponse(serviceCount,employeeCount,assetCount);
        return dashboardReportResponse;
    }



}
