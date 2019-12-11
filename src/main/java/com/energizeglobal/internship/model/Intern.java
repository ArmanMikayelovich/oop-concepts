package com.energizeglobal.internship.model;

import com.energizeglobal.internship.util.EmployeeRole;
import com.energizeglobal.internship.util.exception.IncompatibleSpecializationException;
import com.energizeglobal.internship.util.exception.LoadFactorTooMuchException;

import java.util.Date;

public class Intern extends Employee {
    private Middle mentor;

    public Intern(String firstName, String lastName,
                  Date dateOfBirth, EmployeeRole employeeRole,
                  Integer salary, Middle mentor) {
        super(firstName, lastName, dateOfBirth, employeeRole, salary);
        setMentor(mentor);
    }

    @Override
    public void addTask(String taskCode, String description) {
        if (tasks.size() > 5) {
            throw new LoadFactorTooMuchException();
        }
        super.addTask(taskCode, description);
    }

    public String getMentorName() {
        return mentor.getFirstName() + " " + mentor.getLastName();
    }

    public void setMentor(Middle mentor) {
        if (!mentor.getEmployeeRole().equals(this.getEmployeeRole())) {
            throw new IncompatibleSpecializationException();
        }
        this.mentor = mentor;
        mentor.getStudents().add(this);
    }

}
