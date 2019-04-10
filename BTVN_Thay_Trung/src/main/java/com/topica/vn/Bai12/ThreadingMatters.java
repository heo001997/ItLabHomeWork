package com.topica.vn.Bai12;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadingMatters {
    public static void main(String[] args) {
        ArrayBlockingQueue<RunnableModel> threadQueue = new ArrayBlockingQueue<>(5);

        RunnableModel runnableModel1 = new RunnableModel("1st");
        RunnableModel runnableModel2 = new RunnableModel("2nd");

        try{
            runnableModel1.start();

            TimeUnit.SECONDS.sleep(5);
            if (runnableModel1.isAlive()){
                runnableModel1.interrupt();
                System.out.println("Kill this thread now!");
            }
            runnableModel2.start();

        } catch (InterruptedException ie){
            System.out.println("Sleep In Main Interrupted");
        }

        System.out.println("==> Main thread end!!!");
    }
}
