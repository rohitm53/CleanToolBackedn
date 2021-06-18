package com.indiacleantool.cleantool.web.companymodules.companyavailabletimeslots;

import com.indiacleantool.cleantool.dao.BaseDao;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.StringJoiner;

@Service
public class CompanyTimeSlotsDao extends BaseDao {


    public boolean updateEmployeeCountInCompanyTimeSlots(String companyCode , boolean isIncrement){

        try{
            StringJoiner query = new StringJoiner(" ");
            if(isIncrement){
                query
                        .add(" UPDATE company_time_slots  ")
                        .add(" SET available_employee_count = available_employee_count+1  ")
                        .add(" where company_code = :companyCode ");
            }else{
                query
                        .add(" UPDATE company_time_slots  ")
                        .add(" SET available_employee_count = available_employee_count-1  ")
                        .add(" where company_code = :companyCode ");
            }

            Query nativeQuery = getEntityManager().createNativeQuery(query.toString());
            nativeQuery.setParameter("companyCode",companyCode);
            nativeQuery.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
       return true;

    }


}
