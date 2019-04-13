package com.topica.vn.Bai14b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.topica.vn.Bai14b.SqlConnectionPoolReplica.*;
import static com.topica.vn.Bai14b.SqlConnectionPoolReplica.password;

public class ConnectionModel {
    private Connection connection;
    private Integer active;

    public ConnectionModel(){
        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url + "/" + database,user,password);
            this.active = 0;
        } catch (SQLException e) {
            System.out.println("SQLException in ConnectionModel");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException in ConnectionModel");
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
