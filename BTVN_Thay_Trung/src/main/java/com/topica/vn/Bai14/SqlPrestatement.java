package com.topica.vn.Bai14;

import java.io.IOException;
import java.sql.*;

public class SqlPrestatement {

    public static String driver = "";
    public static String url = "";
    public static String database = "";
    public static String user = "";
    public static String password = "";

    public static void main(String[] args){
        Connection connection = null;

        try {
            ReadProperties readProperties = new ReadProperties();
            readProperties.getPropertiesValue();

            Class.forName(driver);
            connection= DriverManager.getConnection(url + "/" + database,user,password);

            CallableStatement cS = connection.prepareCall("{call getIdByEname(?, ?)}"); // (IN TEMPNAME, OUT EID)

            String ename = "Nguyen Van A";
            cS.setString(1, ename);

            cS.registerOutParameter(2, Types.INTEGER);
            cS.registerOutParameter("EID", Types.INTEGER);

            boolean hadResult = cS.execute();

            while (hadResult){
                ResultSet rS = cS.getResultSet();
                ResultSetMetaData rSMD = rS.getMetaData();
                int colNumber = rSMD.getColumnCount();

                while (rS.next()){
                    for (int i=1; i<=colNumber; i++){                       // SQL ResultSet start from 1
                        if (i > 1) System.out.println(", ");
                        int colValue = rS.getInt(i);
                        System.out.println(rSMD.getColumnName(i) + " : " + colValue);
                    }
                    System.out.println();
                }
                hadResult = cS.getMoreResults();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}