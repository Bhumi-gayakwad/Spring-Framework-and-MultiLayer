package com.employee_payroll_app.employee_payroll_app.controller;

import com.employee_payroll_app.employee_payroll_app.dto.EmployeePayrollDto;
import com.employee_payroll_app.employee_payroll_app.model.EmployeePayroll;
import com.employee_payroll_app.employee_payroll_app.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollServiceController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/"})
    public String getEmployeePayrollByDefault(){
        log.info("Getting employee payroll by default");
        return "Get Employee payroll default route";
    }

    @GetMapping("/get/{name}")
    public EmployeePayroll getEmployeePayrollByName(@PathVariable String name){
        log.info("Getting employee payroll of name {}", name);
        EmployeePayroll employeePayroll = employeePayrollService.getEmployeePayrollByName(name);
        log.info("Employee payroll fetched of name {}", employeePayroll);
        return employeePayroll;
    }

    @GetMapping("/get/all")
    public List<EmployeePayroll> getEmployeePayrolls(){
        log.info("Getting all employee payroll");
        List<EmployeePayroll> employeePayrolls = employeePayrollService.getEmployeePayrolls();
        log.info("all employee payroll fetched {}", employeePayrolls);
        return employeePayrolls;
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployeePayroll(@Valid @RequestBody EmployeePayrollDto employeePayroll){
        log.info("creating employee payroll using following employee payroll dto {}", employeePayroll);
        EmployeePayroll newEmployeePayroll = employeePayrollService.createEmployeePayroll(employeePayroll);
        log.info("new employee payroll created using employee payroll dto is {}", newEmployeePayroll);
        return newEmployeePayroll;
    }

    @PutMapping("/update")
    public EmployeePayroll updateEmployeePayroll(@Valid @RequestBody EmployeePayrollDto employeePayrollDto){
        log.info("updating employee payroll using employee payroll dto {}", employeePayrollDto);
        EmployeePayroll updatedEmployeePayroll = employeePayrollService.updateEmployeePayroll(employeePayrollDto);
        log.info("updated employee payroll using employee payroll dto is {}", updatedEmployeePayroll);
        return updatedEmployeePayroll;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollById(@PathVariable String id){
        log.info("delete employee payroll of id {}", id);
        String deletedResponse = employeePayrollService.deleteEmployeePayrollById(Long.parseLong(id));
        if(!deletedResponse.isEmpty()) log.info("deleted employee payroll");
        return deletedResponse;
    }

}
