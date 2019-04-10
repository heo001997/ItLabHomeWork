package com.topica.vn.Bai13b;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",4444);

//        CreateStream currentStream = new CreateStream(socket);
//
//        ReadThread readThread = new ReadThread(currentStream);
//        readThread.start();
//
//        WriteThread writeThread = new WriteThread(currentStream);
//        writeThread.start();
    }
}