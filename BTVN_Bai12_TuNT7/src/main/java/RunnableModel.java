import static java.lang.Thread.sleep;

public class RunnableModel implements Runnable{
    private Thread thread;
    private String threadName;

    RunnableModel(String threadName){
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void run(){
        System.out.println("Run Thread " + threadName);
        try {
            int i = 1;
            while (true){
                System.out.println("Thread " + threadName + " has been running " + i + " time");
                sleep(100);
                i++;
            }
        } catch (InterruptedException ie){
            System.out.println("Thread " + threadName + " has been interrupted");
        }

    }

    public boolean isAlive(){
        return thread.isAlive();
    }

    public void interrupt(){
        thread.interrupt();
    }

    public void start(){
        System.out.println("Starting " + threadName);
        if (this.thread == null) {
            this.thread = new Thread(this, threadName);
            this.thread.start();
        }
    }
}
