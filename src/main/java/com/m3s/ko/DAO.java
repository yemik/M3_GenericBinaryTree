package com.m3s.ko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> {

    private String query = "SELECT * FROM emp";

    public void addEmployees(BinaryTreeGeneric<Employee> treeGeneric) {
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("empno");
                String name = resultSet.getString("ename");
                Integer salary = resultSet.getInt("sal");
                treeGeneric.addNode(new Employee(id, name, salary));
                TreeLogger.logger.trace("Added employee " + id + ":" + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(connection);
        }
    }

    public List<Employee> getEmployees() {
        Connection connection = null;
        List<Employee> employees = new ArrayList<>();
        try {
            connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("empno");
                String name = resultSet.getString("ename");
                Integer salary = resultSet.getInt("sal");
                employees.add(new Employee(id, name, salary));
                TreeLogger.logger.trace("Added employee " + id + ":" + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.closeConnection(connection);
        }
        return employees;
    }
}
