package com.topica.vn.Bai13a;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CreateStream {
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;

    CreateStream (Socket socket) throws IOException{
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void closeStreamConnection () throws IOException {
        if (dataInputStream != null)
            dataInputStream.close();
        if (dataOutputStream != null)
            dataOutputStream.close();
    }

    public void writeUTF (String str) throws IOException {
        dataOutputStream.writeUTF(str);
    }

    public String readUTF () throws IOException {
        return dataInputStream.readUTF();
    }
}
