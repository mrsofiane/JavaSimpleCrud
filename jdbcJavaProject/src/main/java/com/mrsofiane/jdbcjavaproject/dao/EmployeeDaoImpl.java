package com.mrsofiane.jdbcjavaproject.dao;

import com.mrsofiane.jdbcjavaproject.model.Employee;
import com.mrsofiane.jdbcjavaproject.model.EmployeeBuilder;
import sun.awt.image.ImageWatched;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {


    public List<Employee> findAll() {
        Connection connection = DbConnection.getConnection();
        if ( connection == null) {
            return null;
        }
        List<Employee> employees = new LinkedList<>();

        String sql = "SELECT id, name, gender, salary FROM employee;";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                Employee employee = new EmployeeBuilder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .salary(resultSet.getDouble("salary"))
                        .build();

                employees.add(employee);
            }

        }catch (SQLException se){

            se.printStackTrace();
        }
        return employees;
    }

    public Employee findById(int id) {

        Connection connection = DbConnection.getConnection();
        if (connection == null){
            return null;
        }

        String sql = "SELECT id, name, gender, salary FROM employee WHERE id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return new EmployeeBuilder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .gender(resultSet.getBoolean("gender"))
                        .salary(resultSet.getDouble("salary"))
                        .build();
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return null;
    }

    public void save(Employee employee) {

        Connection connection = DbConnection.getConnection();
        if (connection == null)
            return;
        if (employee.getId() > 0 ) { // update employee

            String sql = "UPDATE  employee set name=?,gender=?,salary=? WHERE id=?;";
            try {
                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender());
                preparedStatement.setDouble(3,employee.getSalary());
                preparedStatement.setInt(4,employee.getId());
                preparedStatement.executeUpdate();

            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }

        } else { // Create new Employee

            String sql = "INSERT INTO employee (name,gender,salary) VALUES (?, ?, ?);";
            try {
                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setBoolean(2,employee.isGender());
                preparedStatement.setDouble(3,employee.getSalary());
                preparedStatement.executeUpdate();

            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }

    }

    public void deleteById(int id) {

        Connection connection = DbConnection.getConnection();

        if (connection == null)
            return;
        String sql = "DELETE FROM employee WHERE id=?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
           preparedStatement.executeUpdate();


        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }


    }
}
