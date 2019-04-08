import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        Socket socket = serverSocket.accept();

        CreateStream currentStream = new CreateStream(socket);

        WriteThread writeThread = new WriteThread(currentStream);
        writeThread.start();

        ReadThread readThread = new ReadThread(currentStream);
        readThread.start();
    }
}
