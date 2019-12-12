package com.energizeglobal.internship.service;

import com.energizeglobal.internship.model.Employee;
import com.energizeglobal.internship.model.SuperVisor;

import java.util.Map;
import java.util.Scanner;

public class SuperVisorService {
    public void addReprimandForEmployee(Map<Integer, Employee> company, Scanner scanner) {
        try {
            System.out.println("input supervisor id.");
            int superVisorId = scanner.nextInt();
            if (superVisorId >= 0 && superVisorId < company.size()
                    && company.get(superVisorId) instanceof SuperVisor) {
                SuperVisor superVisor = (SuperVisor) company.get(superVisorId);
                System.out.println("Input employee id");
                int employeeId = scanner.nextInt();
                if (employeeId >= 0 && employeeId < company.size()) {
                    Employee employee = company.get(employeeId);
                    System.out.println("Input reprimand text.");
                    String reprimandText = scanner.next();
                    superVisor.addReprimandForEmployee(employee, reprimandText);
                } else {
                    System.out.println("Invalid Employee id.");
                }
            } else {
                System.out.println("Invalid SuperVisor id");
            }
        } catch (Exception ex) {
            System.out.println("Unknown exception throw. operation stopped.");
        }

    }

}
