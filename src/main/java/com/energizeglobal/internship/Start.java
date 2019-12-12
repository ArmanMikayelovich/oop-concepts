package com.energizeglobal.internship;

import com.energizeglobal.internship.model.Employee;
import com.energizeglobal.internship.service.HrService;
import com.energizeglobal.internship.service.SuperVisorService;
import com.energizeglobal.internship.service.TaskService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        HrService hrService = new HrService();
        TaskService taskService = new TaskService();
        SuperVisorService superVisorService = new SuperVisorService();
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("In this program you can add Employees to company, and, if need, reprimand them.");
        while (true) {
            System.out.println("What king of operation you need to execute?\n" +
                    "1. Add employee\n" +
                    "2. Reprimand\n" +
                    "3. See company profile\n" +
                    "4. Fire employee\n" +
                    "5. Add task to employee\n" +
                    "6. delete task from employee's task list\n" +
                    "7. Get reprimands' report.");
            System.out.println("Type 'exit' for close.");
            String next = scanner.next();
            try {
                if ("exit".equals(next)) {
                    break;
                }
                int operationType = Integer.parseInt(next);
                switch (operationType) {
                    case 1: {
                        hrService.addEmployee(employeeMap, scanner);
                        break;
                    }
                    case 2: {
                        superVisorService.addReprimandForEmployee(employeeMap, scanner);
                        break;
                    }
                    case 3: {
                        System.out.println(employeeMap.toString());
                        break;
                    }
                    case 4: {
                        hrService.fire(employeeMap, scanner);
                        break;
                    }
                    case 5: {
                        taskService.addTaskForEmployee(employeeMap, scanner);
                        break;
                    }
                    case 6: {
                        taskService.deleteTaskFromUser(employeeMap, scanner);
                        break;
                    }
                    case 7: {
                        superVisorService.reportReprimandsFromConcreteSuperVisor(employeeMap, scanner);
                        break;
                    }
                    default: {
                        System.out.println("Input error. Please try again.");
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Input error. Please try again.");
            }

        }

    }

}
