package com.topica.vn.Bai14b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionThreadModel extends Thread {
    ConnectionPool connectionPool;
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    ConnectionThreadModel(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            System.out.println("Start a new Thread");
            connection =  connectionPool.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getString("ID") +
                        " ENAME: " + resultSet.getString("ENAME") +
                        " AGE: " + resultSet.getString("AGE") +
                        " SALARY: " + resultSet.getString("SALARY") +
                        " COM: " + resultSet.getString("COM") +
                        " POS: " + resultSet.getString("POS") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Thread has been Interrupted in ConnectionThreadModel");
        }
    }
}
