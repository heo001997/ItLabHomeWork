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

            int maxActive = 2;
            ConnectionPool connectionPool = new ConnectionPool(maxActive);
            connectionPool.showStatus();

            // Connect to DB by Connection pool - Will be full and interrupted
            for (int i=0; i<maxActive+3; i++){
                Thread t1 = new Thread(new ConnectionThreadModel(connectionPool));
                t1.start();

                Thread.sleep(3000);
                connectionPool.showStatus();
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Thread has been Interrupted");
        }
//        catch (SQLException e){
//            System.out.println("SQLException in SqlConnectionPoolReplica");
//        }
    }
}