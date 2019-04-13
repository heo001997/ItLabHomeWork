package LinkedListDeleteDuplicate;

import java.io.*;

public class FileTxt {
    InputStream is = null;
    DataInputStream dis = null;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    DataOutputStream dos = null;

    public FileTxt(String INPUT, String OUTPUT){
        try {
            this.fos = new FileOutputStream(OUTPUT);
            this.dos = new DataOutputStream(fos);
            fis = new FileInputStream(INPUT);
            this.dis = new DataInputStream(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection (){

    }
}
