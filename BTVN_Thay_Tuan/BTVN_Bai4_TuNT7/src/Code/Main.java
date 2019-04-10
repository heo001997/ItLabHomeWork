package Code;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static final String INDIR = "F:\\Bai4KieuSida\\src\\Resources\\b4_rawgoc.txt";
    public static final String OUTDIR = "F:\\Bai4KieuSida\\src\\Resources\\b4_rawout.txt";
    public static Map<String, Integer> unsortMap = new HashMap<>();
    public static TextFile textFile = new TextFile(INDIR, OUTDIR);

    public void wordProcess (String word){
        boolean isKeyPresent = unsortMap.containsKey(word);

        if (isKeyPresent == false){
            unsortMap.put(word, 1);
        }else{
            unsortMap.put(word, unsortMap.get(word) + 1);
        }
    }

    public static void main(String[] args) {
        Main lister = new Main();

        String currentLine = null;
        String[] wordSplitList = null;

        try {
            while((currentLine = textFile.bufferedReader.readLine()) != null){
                wordSplitList = currentLine.split("\\W+");
                int wordSplitListLength = wordSplitList.length;
                for(int pos = 0; pos < wordSplitListLength; pos++){
                    if (!wordSplitList[pos].equals("")){
                        lister.wordProcess(wordSplitList[pos].toLowerCase());
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        Map<String, Integer> sortedMap = sortByValue(unsortMap);
        showMap(sortedMap);

        textFile.closeTextFile();

        try{
            File file = new File(OUTDIR);
            Desktop desktop = Desktop.getDesktop();

            desktop.open(file);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


        System.out.println("OKDONE");
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // Map ---> List<Map> ---> Collections.sort() --> List<Map> (Sorted) ---> LinkedHashMap
        List<Map.Entry<String, Integer>> list = new LinkedList(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> pos1, Map.Entry<String, Integer> pos2) {
                return (pos2.getValue()).compareTo(pos1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void showMap(Map<String, Integer> map) {
        try{
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String strKey = "'" + entry.getKey() + "'";
                String strMid = " counts ";
                String strValue = entry.getValue() + " times";
                textFile.bufferedWriter.write(String.format("%-25s",strKey));
                textFile.bufferedWriter.write(String.format(strMid));
                textFile.bufferedWriter.write(String.format("%15s", strValue));
                textFile.bufferedWriter.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
        }

    }
}