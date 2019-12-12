package com.energizeglobal.internship.service;

import com.energizeglobal.internship.model.Employee;
import com.energizeglobal.internship.model.EmployeeDto;
import com.energizeglobal.internship.model.OfficeWorker;
import com.energizeglobal.internship.model.SuperVisor;
import com.energizeglobal.internship.util.OfficeWorkerRole;
import com.energizeglobal.internship.util.SeniorityLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class HrService {
    private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public void addEmployee(Map<Integer, Employee> company, Scanner scanner) {
        try {

            System.out.println("What kind of employee do you employ?\n" +
                    "1. OfficeWorker\n" +
                    "2. SuperVisor");
            switch (scanner.nextInt()) {
                case 1: {
                    OfficeWorker officeWorker = addOfficeWorker(scanner);
                    company.put(officeWorker.getId(), officeWorker);
                    break;
                }
                case 2: {
                    SuperVisor superVisor = addSuperVisor(scanner);
                    company.put(superVisor.getId(), superVisor);
                    break;
                }
                default: {
                    System.out.println("Input error, canceling operation");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Unknown exception throw. operation stopped.");
        }


    }

    private OfficeWorker addOfficeWorker(Scanner scanner) {
        EmployeeDto employeeDto = getEmployeeArguments(scanner);
        System.out.println("Input work type.\n" +
                "1. Software developer \n" +
                "2. Business Analytic \n" +
                "3. QA engineer \n" +
                "4. Project manager\n" +
                "5. HR manager\n" +
                "6. IT specialist\n");
        OfficeWorkerRole officeWorkerRole = null;
        while (true) {
            int workTypeOrdinal = scanner.nextInt() - 1;
            if (workTypeOrdinal >= 0 && workTypeOrdinal < OfficeWorkerRole.values().length) {
                officeWorkerRole = OfficeWorkerRole.values()[workTypeOrdinal];
                break;
            }
            System.out.println("Input valid number.");
        }
        System.out.println("Input seniority level.\n" +
                "1. junior\n" +
                "2. middle \n" +
                "3. senior\n");

        SeniorityLevel seniorityLevel = null;
        while (true) {
            int seniorityLevelOrdinal = scanner.nextInt() - 1;
            if (seniorityLevelOrdinal >= 0 && seniorityLevelOrdinal < SeniorityLevel.values().length) {
                seniorityLevel = SeniorityLevel.values()[seniorityLevelOrdinal];
                break;
            }
            System.out.println("Input valid number.");
        }
        return new OfficeWorker(employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getDateOfBirth(), officeWorkerRole, employeeDto.getSalary(), seniorityLevel);
    }

    private SuperVisor addSuperVisor(Scanner scanner) {
        EmployeeDto employeeDto = getEmployeeArguments(scanner);
        return new SuperVisor(employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getDateOfBirth(), employeeDto.getSalary());
    }

    private EmployeeDto getEmployeeArguments(Scanner scanner) {
        System.out.println("Type first name.");
        String firstName = scanner.next();
        System.out.println("Type last name.");
        String lastName = scanner.next();
        System.out.println("Type date of birth in format dd/MM/yyyy");
        Date dateOfBirth = null;
        while (true) {
            try {
                dateOfBirth = dateFormatter.parse(scanner.next());
                break;
            } catch (ParseException ex) {
                System.out.println("Invalid date.");
            }
        }
        System.out.println("Input salary.");
        int salary = scanner.nextInt();
        return new EmployeeDto(firstName, lastName, dateOfBirth, salary);
    }

    public void fire(Map<Integer, Employee> company, Scanner scanner) {
        try {
            System.out.println("Input employee id");
            int employeeId = scanner.nextInt();
            if (employeeId >= 0 && employeeId < company.size()) {
                company.remove(employeeId);
            } else {
                System.out.println("Invalid employee id");
            }
        } catch (Exception ex) {
            System.out.println("Unknown exception throw. operation stopped.");
        }
    }

}
