package LinkedListDeleteDuplicate;

import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DuplicateDelete {

    private static String INPUT = "F:\\Code GitHub\\ItLabHomeWork\\BTVN_Thay_Huy\\src\\main\\java\\LinkedListDeleteDuplicate\\INPUT\\INPUT.txt";
    private static String OUTPUT = "F:\\Code GitHub\\ItLabHomeWork\\BTVN_Thay_Huy\\src\\main\\java\\LinkedListDeleteDuplicate\\OUTPUT\\OUTPUT.txt";
    public static List<Integer> linkedlist = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        FileTxt fileTxt = new FileTxt(INPUT, OUTPUT);

        while (fileTxt.dis.available() > 0){
            fileTxt.dis.readUTF();
            int k = fileTxt.dis.readInt();
            linkedlist.add(k);
        }

        System.out.println("List are: " + linkedlist);
    }
}
