package com.mrsofiane.jdbcjavaproject;

import com.mrsofiane.jdbcjavaproject.dao.DbConnection;
import com.mrsofiane.jdbcjavaproject.dao.EmployeeDao;
import com.mrsofiane.jdbcjavaproject.dao.EmployeeDaoImpl;
import com.mrsofiane.jdbcjavaproject.model.Employee;
import com.mrsofiane.jdbcjavaproject.model.EmployeeBuilder;

import javax.management.monitor.Monitor;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

//        EmployeeDao employeeDao = new EmployeeDaoImpl();
//
//        Employee employee = new EmployeeBuilder()
//                .name("Mr khalil")
//                .gender(true)
//                .salary(2500)
//                .build();


        //employeeDao.save(employee);

//        employeeDao.deleteById(1);

//        List<String> collect = employeeDao.findAll().stream().map(Employee::getName).collect(Collectors.toList());
//        System.out.println(collect);

    }
}
