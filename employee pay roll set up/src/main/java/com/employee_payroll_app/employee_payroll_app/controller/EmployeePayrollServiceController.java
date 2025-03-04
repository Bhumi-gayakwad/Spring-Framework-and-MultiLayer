package com.employee_payroll_app.employee_payroll_app.controller;

import com.employee_payroll_app.employee_payroll_app.dto.EmployeePayrollDto;
import com.employee_payroll_app.employee_payroll_app.model.EmployeePayroll;
import com.employee_payroll_app.employee_payroll_app.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollServiceController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/"})
    public String getEmployeePayrollByDefault(){
        return "Get Employee payroll default route";
    }

    @GetMapping("/get/{id}")
    public EmployeePayroll getEmployeePayrollById(@PathVariable String id){
        return employeePayrollService.getEmployeePayrollById(Long.parseLong(id));
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployeePayroll(@RequestBody EmployeePayrollDto employeePayroll){
        return employeePayrollService.createEmployeePayroll(employeePayroll);
    }

    @PutMapping("/update")
    public EmployeePayroll updateEmployeePayroll(@RequestBody EmployeePayrollDto employeePayroll){
        return employeePayrollService.updateEmployeePayroll(employeePayroll);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollById(@PathVariable String id){
        return employeePayrollService.deleteEmployeePayrollById(Long.parseLong(id));
    }

}