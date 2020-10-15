package com.indiacleantool.cleantool.web.frontendmodules.dashboard;

import com.indiacleantool.cleantool.web.models.frontendmodals.companydashboard.DashboardReportResponse;
import com.indiacleantool.cleantool.web.frontendmodules.asset.AssetService;
import com.indiacleantool.cleantool.web.frontendmodules.companyservice.CompanyServiceSprService;
import com.indiacleantool.cleantool.web.frontendmodules.employees.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AssetService assetService;

    @Autowired
    private CompanyServiceSprService companyServiceSprService;

    public DashboardReportResponse getInitialDashboarReport(String compnayCode){

        Long serviceCount  =  companyServiceSprService.getCountByCompanyCode(compnayCode);
        Long employeeCount =  employeeService.getCountByCompanyCode(compnayCode);
        Long assetCount    =  assetService.getCountByCompanyCode(compnayCode);

        DashboardReportResponse dashboardReportResponse = new DashboardReportResponse(serviceCount,employeeCount,assetCount);
        return dashboardReportResponse;
    }



}
