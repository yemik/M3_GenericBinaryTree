package com.m3s.ko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection() throws SQLException {
        String path = "jdbc:oracle:thin:@10.20.40.53:1521:oradb1";
        String user = "user1";
        String password = "Pa55w0rd";
        return DriverManager.getConnection(path,user,password);
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
