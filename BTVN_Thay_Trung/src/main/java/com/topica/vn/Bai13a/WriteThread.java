package com.topica.vn.Bai13a;

import java.io.IOException;
import java.util.Scanner;

public class WriteThread extends Thread {
    CreateStream currentStream;
    Scanner scanner = new Scanner(System.in);

    WriteThread(CreateStream currentStream){
        this.currentStream = currentStream;
    }

    @Override
    public void run() {
        while (true){
            try {
                currentStream.writeUTF(scanner.nextLine());
                currentStream.dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
