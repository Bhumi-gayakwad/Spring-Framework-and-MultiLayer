package com.employee_payroll_app.employee_payroll_app.model;

import jakarta.persistence.*;
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

    private String name;
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
