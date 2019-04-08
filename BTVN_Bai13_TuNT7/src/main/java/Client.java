import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",4444);

        CreateStream currentStream = new CreateStream(socket);

        ReadThread readThread = new ReadThread(currentStream);
        readThread.start();

        WriteThread writeThread = new WriteThread(currentStream);
        writeThread.start();
    }
}
