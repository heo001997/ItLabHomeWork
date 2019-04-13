package com.topica.vn.Bai14b;

import com.topica.vn.Bai14.ReadProperties;

import java.io.IOException;
import java.sql.*;

public class SqlConnectionPoolReplica {

    public static String driver = "";
    public static String url = "";
    public static String database = "";
    public static String user = "";
    public static String password = "";

    public static void main(String[] args){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            ReadProperties readProperties = new ReadProperties();
            readProperties.getPropertiesValue();

            int maxActive = 5;
            ConnectionPool connectionPool = new ConnectionPool(maxActive);

            connectionPool.setMaxActive(5);
            connectionPool.showStatus();

            // Connect to DB by Connection pool
            connection = connectionPool.getConnection();
            connectionPool.showStatus();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("SQLException in SqlConnectionPoolReplica");
        }
    }
}