package com.energizeglobal.internship.model;

import com.energizeglobal.internship.util.EmployeeRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Middle extends Junior {
    private List<Intern> students = new ArrayList<>();
    public Middle(String firstName, String lastName, Date dateOfBirth, EmployeeRole employeeRole, Integer salary) {
        super(firstName, lastName, dateOfBirth, employeeRole, salary);
    }

    public Middle(Junior junior, Integer salary) {
        super(junior.getFirstName(), junior.getLastName(),
                junior.getDateOfBirth(), junior.getEmployeeRole(),
                salary);
    }

    public List<Intern> getStudents() {
        return students;
    }
}
