package org.example.repository;

import org.example.model.Employee;
import org.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {


    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }

    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection myCoon = getConnection(); Statement myStamt = myCoon.createStatement(); ResultSet myRes = myStamt.executeQuery("SELECT * FROM employee")) {
            while (myRes.next()) {
                Employee employee = createEmployees(myRes);
                employees.add(employee);
            }
        }
        return employees;
    }


    @Override
    public Employee getById(Integer id) throws SQLException {
        Employee employee = null;
        try (Connection myCoon = getConnection(); PreparedStatement myStamt = getConnection().prepareStatement("SELECT * FROM employee WHERE id = ?")) {
            myStamt.setInt(1, id);
            try (ResultSet myRes = myStamt.executeQuery()) {
                if (myRes.next()) {
                    employee = createEmployees(myRes);
                }
            }
        }
        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        String sql;
        if (employee.getId() != null && employee.getId() > 0) {
            sql = "UPDATE employee SET firstName = ?, firstSurname = ?, SecondSurname = ?, email = ?, salary = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO employee (firstName,firstSurname,secondSurname,email,salary) VALUES(?,?,?,?,?)";
        }


        try (Connection myCoon = getConnection(); PreparedStatement myStamt = getConnection().prepareStatement(sql)) {
            myStamt.setString(1, employee.getFirstName());
            myStamt.setString(2, employee.getFirstSurname());
            myStamt.setString(3, employee.getSecondSurname());
            myStamt.setString(4, employee.getEmail());
            myStamt.setFloat(5, employee.getSalary());
            if (employee.getId() != null && employee.getId() > 0) {
                myStamt.setInt(6, employee.getId());
            }
            myStamt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection myCoon = getConnection(); PreparedStatement myStamt = getConnection().prepareStatement("DELETE FROM employee WHERE id = ?")) {
            myStamt.setInt(1, id);
            myStamt.executeUpdate();
        }
    }

    private Employee createEmployees(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirstName(myRes.getString("firstName"));
        e.setFirstSurname(myRes.getString("firstSurname"));
        e.setSecondSurname(myRes.getString("secondSurname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        return e;
    }
}
