package com.topica.vn.Bai14;

import java.sql.*;

public class SqlProcedure {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","Dunghoi123!@#");

        CallableStatement cSm = connection.prepareCall("{call getID(?, ?)}");
        cSm.setString(1, "Computers");
        cSm.registerOutParameter(2, Types.INTEGER);
        cSm.registerOutParameter("total", Types.INTEGER);

        boolean hadResult = cSm.execute();

        while (hadResult){
            ResultSet rs = cSm.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colNumber = rsmd.getColumnCount();

            while (rs.next()){
                for (int i=1; i<=colNumber; i++){
                    if (i > 1) System.out.println(", ");
                    int colValue = rs.getInt(i);
                    System.out.println(rsmd.getColumnName(i) + " : " + colValue);
                }
                System.out.println("");
            }

            hadResult = cSm.getMoreResults();
        }
//        int total;
//        CallableStatement stm = connection.prepareCall("{ call getID('History', @total) }");
//        stm.registerOutParameter(1, Types.INTEGER);
//        stm.execute();
//        total = stm.getInt(1);
//        String m_count = stm.getString(1);
//        stm.close();
    }
//here sonoo is database name, root is username and password

//
//
//    CallableStatement stm = connection.prepareCall("{ call CountMembers(?) }");
//    stm.registerOutParameter(1, Types.VARCHAR);
//    stm.execute();
//    String m_count = stm.getString(1);
//    stm.close();
}
