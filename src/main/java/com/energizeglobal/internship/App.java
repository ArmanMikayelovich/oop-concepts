package com.energizeglobal.internship;

import com.energizeglobal.internship.model.*;
import com.energizeglobal.internship.util.EmployeeRole;
import com.energizeglobal.internship.util.exception.IncompatibleSpecializationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        Senior senior = new Senior("M", "& M's",
                new GregorianCalendar(95, Calendar.FEBRUARY, 10).getTime(),
                EmployeeRole.SOFTWARE_DEVELOPER, 1500);
        System.out.println(senior.toString());

        Employee intern = new Intern("John", "Karter",
                new GregorianCalendar(1990, Calendar.APRIL, 20).getTime(),
                EmployeeRole.SOFTWARE_DEVELOPER,
                200, senior);
        System.out.println(intern.toString());
        System.out.println(senior.toString());

        Junior junior = new Junior((Intern) intern, 1500);
        System.out.println(junior.toString());

        Junior stanislavVsyakov = new Junior("Stanislav", "Vsyakov",
                new GregorianCalendar(2000, Calendar.NOVEMBER, 15).getTime(),
                EmployeeRole.HR_MANAGER, 2000);
        System.out.println(stanislavVsyakov.toString());
        Middle middle = new Middle(stanislavVsyakov, 3000);
        System.out.println(stanislavVsyakov.toString());

        Senior seniorQA = new Senior("M", "& M's",
                new GregorianCalendar(95, Calendar.FEBRUARY, 10).getTime(),
                EmployeeRole.QA_ENGINEER, 5000);
        System.out.println(seniorQA.toString());

        Employee analytic;
        EmployeeRole analyticRole = EmployeeRole.BUSINESS_ANALYTIC;
        try {
             analytic=new Intern("Armen", "kadirov",
                    new GregorianCalendar(1996, Calendar.NOVEMBER, 15).getTime(),
                    EmployeeRole.BUSINESS_ANALYTIC, 230, seniorQA);
        } catch (IncompatibleSpecializationException ex) {
            System.err.println("The " + seniorQA.getEmployeeRole().toString() +
                    " can't be mentor for "
                    + analyticRole.toString());
        }

    }

}
