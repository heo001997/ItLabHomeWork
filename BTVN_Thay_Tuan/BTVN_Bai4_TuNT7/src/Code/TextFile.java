package Code;

import java.io.*;

public class TextFile {
    BufferedReader bufferedReader = null;
    FileReader fileReader = null;
    BufferedWriter bufferedWriter = null;
    FileWriter fileWriter = null;

    public TextFile(String INDIR, String OUTDIR) {
        try {
            this.bufferedReader = new BufferedReader(fileReader = new FileReader(INDIR));
            this.bufferedWriter = new BufferedWriter(fileWriter = new FileWriter(OUTDIR));
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void closeTextFile (){
        try{
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (fileReader != null){
                fileReader.close();
            }
            if (fileWriter != null){
                fileWriter.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
