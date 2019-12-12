package com.energizeglobal.internship.service;

import com.energizeglobal.internship.model.Employee;

import java.util.Map;
import java.util.Scanner;

public class TaskService {
    public void addTaskForEmployee(Map<Integer, Employee> company, Scanner scanner) {
        try {
            System.out.println("Input employee id");
            int employeeId = scanner.nextInt();
            if (employeeId >= 0 && employeeId < company.size()) {
                Employee employee = company.get(employeeId);
                System.out.println("Input task code.");
                String taskCode = scanner.next();
                System.out.println("Input task text.");
                String taskText = scanner.next();
                employee.addTask(taskCode, taskText);
            } else {
                System.out.println("Invalid employee id");
            }
        } catch (Exception ex) {
            System.out.println("Unknown exception throw. operation stopped.");
        }
    }

    public void deleteTaskFromUser(Map<Integer, Employee> company, Scanner scanner) {
        try {
            System.out.println("Input employee id");
            int employeeId = scanner.nextInt();
            if (employeeId >= 0 && employeeId < company.size()) {
                Employee employee = company.get(employeeId);
                System.out.println("Input task code.");
                String taskCode = scanner.next();
                employee.deleteTask(taskCode);
            } else {
                System.out.println("Invalid employee id");
            }
        } catch (Exception ex) {
            System.out.println("Unknown exception throw. operation stopped.");
        }
    }
}
