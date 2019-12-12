package com.energizeglobal.internship.model;

import com.energizeglobal.internship.util.OfficeWorkerRole;
import com.energizeglobal.internship.util.SeniorityLevel;
import com.energizeglobal.internship.util.exception.LoadFactorTooMuchException;

import java.util.Date;

public class OfficeWorker extends Employee {


    private SeniorityLevel seniorityLevel;
    private OfficeWorkerRole role;

    public OfficeWorker(String firstName, String lastName,
                        Date dateOfBirth, OfficeWorkerRole officeWorkerRole,
                        Integer salary, SeniorityLevel seniorityLevel) {

        super(firstName, lastName, dateOfBirth, salary);
        this.seniorityLevel = seniorityLevel;
        this.role = officeWorkerRole;
    }

    public SeniorityLevel getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(SeniorityLevel seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public OfficeWorkerRole getRole() {
        return role;
    }

    @Override
    public void addTask(String taskCode, String description) {
        if (tasks.size() > 5) {
            throw new LoadFactorTooMuchException();
        }
        super.addTask(taskCode, description);
    }


}
