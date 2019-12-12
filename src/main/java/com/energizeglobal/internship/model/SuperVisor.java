package com.energizeglobal.internship.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SuperVisor extends Employee {
    private Map<Employee, String> reprimands = new HashMap<>();

    public SuperVisor(String firstName, String lastName, Date dateOfBirth, Integer salary) {
        super(firstName, lastName, dateOfBirth, salary);
    }

    public Map<Employee, String> getReprimands() {
        return reprimands;
    }

    public void addReprimandForEmployee(Employee employee, String text) {
        reprimands.put(employee, text);
    }

    public String reportReprimands() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Reprimands' count: ").append(reprimands.size()).append(".\n");

        for (Map.Entry<Employee, String> entry : reprimands.entrySet()) {
            Employee employee = entry.getKey();
            reportBuilder.append(employee.getFirstName()).append(" ").append(employee.getLastName())
                    .append(" : ").append(entry.getValue()).append(".\n");
        }
        return reportBuilder.toString();
    }

}
