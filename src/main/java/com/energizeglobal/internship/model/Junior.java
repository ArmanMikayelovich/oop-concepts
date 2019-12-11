package com.energizeglobal.internship.model;

import com.energizeglobal.internship.util.EmployeeRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Junior extends Employee {
    private List<String> benefits = new ArrayList<>();

    public List<String> getBenefits() {
        return benefits;
    }

    public Junior(String firstName, String lastName, Date dateOfBirth, EmployeeRole employeeRole, Integer salary) {
        super(firstName, lastName, dateOfBirth, employeeRole, salary);
    }

    public Junior(Intern intern, Integer salary) {
        super(intern.getFirstName(), intern.getLastName(), intern.getDateOfBirth(), intern.getEmployeeRole(), salary);
    }
}
