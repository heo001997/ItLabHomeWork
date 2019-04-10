package com.topica.vn.Bai13b;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<Socket> socketList = new ArrayList<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);

        Listener listener = new Listener(serverSocket);
        listener.start();
    }
}