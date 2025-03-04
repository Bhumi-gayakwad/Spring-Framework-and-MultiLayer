package com.employee_payroll_app.employee_payroll_app.service;

import com.employee_payroll_app.employee_payroll_app.dto.EmployeePayrollDto;
import com.employee_payroll_app.employee_payroll_app.exception.EmployeePayrollNotFoundException;
import com.employee_payroll_app.employee_payroll_app.model.EmployeePayroll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private final List<EmployeePayroll> employeePayrolls = new ArrayList<>();

    public EmployeePayroll getEmployeePayrollById(Long id) {
        for (EmployeePayroll employeePayroll : employeePayrolls) {
            if (employeePayroll.getId() == id) {
                return employeePayroll;
            }
        }
        return null;
    }

    public EmployeePayroll getEmployeePayrollByName(String name) {
        for (EmployeePayroll employeePayroll : employeePayrolls) {
            if (employeePayroll.getName().equals(name)) {
                return employeePayroll;
            }
        }
        throw new EmployeePayrollNotFoundException(name);
    }

    public List<EmployeePayroll> getEmployeePayrolls(){
        return employeePayrolls;
    }

    public EmployeePayroll createEmployeePayroll(EmployeePayrollDto employeePayrollDto) {
        EmployeePayroll newEmployeePayroll = new EmployeePayroll(employeePayrollDto.getName(), employeePayrollDto.getSalary());
        employeePayrolls.add(newEmployeePayroll);
        return newEmployeePayroll;
    }

    public EmployeePayroll updateEmployeePayroll(EmployeePayrollDto newEmployeePayrollDto) {
        EmployeePayroll newEmployeePayroll = new EmployeePayroll(newEmployeePayrollDto.getName(), newEmployeePayrollDto.getSalary());
        for (int i=0; i<employeePayrolls.size(); i++){
            if (employeePayrolls.get(i).getName() == newEmployeePayroll.getName()){
                employeePayrolls.set(i, newEmployeePayroll);
                return employeePayrolls.get(i);
            }
        }
        throw new EmployeePayrollNotFoundException(newEmployeePayrollDto);
    }

    public String deleteEmployeePayrollById(Long id) {
        for (int i=0; i<employeePayrolls.size(); i++){
            if (employeePayrolls.get(i).getId() == id){
                employeePayrolls.remove(i);
                return "Deleted Employee payroll with Id: "+id;
            }
        }
        throw new EmployeePayrollNotFoundException(id);
    }

}
