package com.indiacleantool.cleantool.web.mobileuersmodules.servicedetails;

import com.indiacleantool.cleantool.dao.BaseDao;
import com.indiacleantool.cleantool.datamodels.common.timeslots.TimeSlot;
import com.indiacleantool.cleantool.datamodels.users.company.Company;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;
import java.util.StringJoiner;

@Service
public class ServiceDetailsDao extends BaseDao {


    public List<Company> getAvailableCompanyByServiceCode(String serviceCode){

        StringJoiner query = new StringJoiner(" ");
        query
                .add(" SELECT CU.* from COMPANY_USER CU ")
                .add(" INNER JOIN COMPANY_SERVICE CS ON CU.COMPANY_CODE=CS.COMPANY_CODE ")
                .add(" INNER JOIN SERVICES S ON S.SERVICE_CODE=CS.SERVICE_CODE ")
                .add(" WHERE  S.SERVICE_CODE = :serviceCode ");

        Query nativeQuery = getEntityManager().createNativeQuery(query.toString(),Company.class);
        nativeQuery.setParameter("serviceCode",serviceCode);
        return nativeQuery.getResultList();
    }

    public List<TimeSlot> getAvailableTimeSlots(String companyCode,String strDate){

        StringJoiner query = new StringJoiner(" ");
        query
                .add(" SELECT TS.* FROM time_slot TS ")
                .add(" INNER JOIN company_time_slots CTS on CTS.time_slot_code=TS.slot_code ")
                .add(" WHERE CTS.available_employee_count > 0 and  ")
                .add(" date(CTS.date)=date(:date) ")
                .add(" and CTS.company_code = :company_code ");

        Query nativeQuery = getEntityManager().createNativeQuery(query.toString(),TimeSlot.class);
        nativeQuery.setParameter("date",strDate);
        nativeQuery.setParameter("company_code",companyCode);

        return nativeQuery.getResultList();

    }

}
