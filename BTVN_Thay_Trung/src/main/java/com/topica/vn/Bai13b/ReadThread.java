package com.topica.vn.Bai13b;

import java.io.IOException;

public class ReadThread extends Thread {
    CreateStream currentStream;

    ReadThread(CreateStream currentStream){
        this.currentStream = currentStream;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(currentStream.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
