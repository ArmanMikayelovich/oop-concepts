package com.energizeglobal.internship.model;

import com.energizeglobal.internship.util.JsonMapper;
import com.energizeglobal.internship.util.exception.JsonParseException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class Employee {
    private static int idSequence = 0;
    private int id;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    private Integer salary;
    protected Map<String, String> tasks = new HashMap<>();

    public Employee(String firstName, String lastName,
                    Date dateOfBirth,
                    Integer salary) {
        this.id = idSequence++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public Map<String, String> getTasks() {
        return tasks;
    }

    public int getId() {
        return id;
    }

    public void addTask(String taskCode, String description) {
        tasks.put(taskCode, description);
    }

    public void deleteTask(String taskCode) {
        tasks.remove(taskCode);
    }

    public String getTask(String taskCode) {
        return tasks.get(taskCode);
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        try {
            return JsonMapper.getInstance().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new JsonParseException("Can't parse object to json format.", e);
        }
    }
}
