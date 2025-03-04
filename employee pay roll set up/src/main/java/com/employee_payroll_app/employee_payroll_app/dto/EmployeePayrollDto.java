package com.employee_payroll_app.employee_payroll_app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeePayrollDto {

    @NotNull
    @Size(min = 2, message = "Name should be atleast 2 characters long")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name should contain only alphabets")
    private String name;

    @NotNull
    private double salary;

    public EmployeePayrollDto() {}

    public EmployeePayrollDto(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

}
