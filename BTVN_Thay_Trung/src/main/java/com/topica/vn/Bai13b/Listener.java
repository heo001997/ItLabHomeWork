package com.topica.vn.Bai13b;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread {
    private ServerSocket serverSocket;

    Listener(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try{
            while (true){
                Socket socket = serverSocket.accept();
                Server.socketList.add(socket);

                Server.socketList.forEach((n) -> System.out.println(n));
            }
        } catch (IOException ioe){
            System.out.println("Interrupted In Listener");
        }

    }
}
