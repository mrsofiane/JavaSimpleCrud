package com.mrsofiane.jdbcjavaproject.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.function.BiConsumer;

public class EmployeeBuilder {

    private int id;
    private String name;
    private boolean gender;
    private double salary;

    public EmployeeBuilder id(int id){
        this.id =id;
        return this;
    }

    public EmployeeBuilder name (String name){
        this.name = name;
        return this;
    }

    public EmployeeBuilder gender(Boolean gender){
        this.gender=gender;
        return this;
    }

    public EmployeeBuilder salary (double salary){
        this.salary=salary;
        return this;
    }

    public Employee build(){
        return new Employee(id,name,gender,salary);
    }
}
