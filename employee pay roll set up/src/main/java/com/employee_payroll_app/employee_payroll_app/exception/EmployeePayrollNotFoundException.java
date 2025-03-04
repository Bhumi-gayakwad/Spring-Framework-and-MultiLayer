package com.employee_payroll_app.employee_payroll_app.exception;

import com.employee_payroll_app.employee_payroll_app.dto.EmployeePayrollDto;

public class EmployeePayrollNotFoundException extends RuntimeException {

    public EmployeePayrollNotFoundException(String name) {
        super("Unable to find employee payroll with name "+name);
    }

    public EmployeePayrollNotFoundException(Long id) {
        super("Unable to find employee payroll with id "+id);
    }

    public EmployeePayrollNotFoundException(EmployeePayrollDto employeePayrollDto) {
        super("Unable to find employee payroll with name "+employeePayrollDto.getName());
    }
}
