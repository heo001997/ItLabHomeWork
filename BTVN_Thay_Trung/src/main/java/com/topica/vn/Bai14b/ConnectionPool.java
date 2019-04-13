package com.topica.vn.Bai14b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.topica.vn.Bai14b.SqlConnectionPoolReplica.*;

public class ConnectionPool {
    int maxActive;
    int numActive;
    int numIdle;
    ConnectionModel connectionModel;
    ArrayBlockingQueue<ConnectionModel> connectionQueue;

    public ConnectionPool(int maxActive) {
        this.maxActive = maxActive;
        this.connectionQueue = new ArrayBlockingQueue<>(maxActive);
    }

    public void showStatus(){
        System.out.println("Max Connection: " + maxActive + "; Active Connection: " + connectionQueue.size() + "; Idle Connection: " + numIdle);
    }

    public Connection getConnection() throws SQLException {
        ConnectionModel connectionModel = new ConnectionModel();
        try {
            connectionQueue.offer(connectionModel, 5, TimeUnit.SECONDS);
            System.out.println("Just put in a new ConnectionModel");
        } catch (IllegalStateException e){
            System.out.println("Queue is already full, please try again later");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connectionModel.getConnection();
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getNumActive() {
        return numActive;
    }

    public void setNumActive(int numActive) {
        this.numActive = numActive;
    }

    public int getNumIdle() {
        return numIdle;
    }

    public void setNumIdle(int numIdle) {
        this.numIdle = numIdle;
    }
}
