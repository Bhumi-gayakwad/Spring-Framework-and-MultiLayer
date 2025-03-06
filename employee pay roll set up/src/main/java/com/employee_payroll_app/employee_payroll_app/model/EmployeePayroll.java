package com.employee_payroll_app.employee_payroll_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employee_payrolls")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //    @NotNull
//    @Size(min = 2, message = "Name should be atleast 2 characters long")
//    @Pattern(regexp = "[A-Za-z]", message = "Name should contain only alphabets")
    private String name;

    //    @NotNull
    private double salary;

    public EmployeePayroll() {}

    public EmployeePayroll(Long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayroll(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

}