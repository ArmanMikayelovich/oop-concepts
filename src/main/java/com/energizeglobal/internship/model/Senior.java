package com.energizeglobal.internship.model;

import com.energizeglobal.internship.util.EmployeeRole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Senior extends Middle {
    private List<String> businessTrips = new ArrayList<>();

    public List<String> getBusinessTrips() {
        return businessTrips;
    }

    public Senior(String firstName, String lastName, Date dateOfBirth, EmployeeRole employeeRole, Integer salary) {
        super(firstName, lastName, dateOfBirth, employeeRole, salary);
    }

    public Senior(Middle middle, Integer salary) {
        super(middle.getFirstName(), middle.getLastName(),
                middle.getDateOfBirth(), middle.getEmployeeRole(),
                salary);
    }
}
