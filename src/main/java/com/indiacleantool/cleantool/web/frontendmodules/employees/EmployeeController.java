package com.indiacleantool.cleantool.web.frontendmodules.employees;

import com.indiacleantool.cleantool.web.domain.users.employee.Employee;
import com.indiacleantool.cleantool.web.exceptions.MapValidationExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/company/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private MapValidationExceptionService mapValidationExceptionService;

    @PostMapping
    public ResponseEntity<?> createOrSaveEmployee(@Valid @RequestBody Employee employee , BindingResult result){

        ResponseEntity<?> errorMap = mapValidationExceptionService.validateRESTRequest(result);
        if(errorMap!=null){
            return errorMap;
        }
        Employee employee1 = service.saveOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);

    }

    @GetMapping("/{employeeCode}")
    public ResponseEntity<?> getEmployeeByEmployeeCode(@PathVariable String employeeCode){
        return new ResponseEntity<>(service.findByEmployeeCode(employeeCode),HttpStatus.OK);
    }

    @GetMapping("/companyemployee/{companyCode}")
    public ResponseEntity<?> getEmployeeByCompanyCode(@PathVariable String companyCode){
        return new ResponseEntity<>(service.findAllByCompanyCode(companyCode),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployee(){
        return new ResponseEntity<>(service.findAllEmployees(),HttpStatus.OK);
    }

    @DeleteMapping("/{employeeCode}")
    public ResponseEntity<?> deleteEmployeeByCode(@PathVariable String employeeCode){
        service.deleteEmployeeByCode(employeeCode);
        return new ResponseEntity<>("Employee with code : "+employeeCode+" has been deleted",HttpStatus.OK);
    }
}
