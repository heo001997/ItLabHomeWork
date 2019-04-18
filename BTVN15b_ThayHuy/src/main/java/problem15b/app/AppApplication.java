package problem15b.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.text.Normalizer;
import java.util.regex.Pattern;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\InputFolder\\input.txt"))) {
            String currLine;
            while ((currLine = bufferedReader.readLine()) != null) {
                System.out.println(currLine);

                System.out.println(deAccent(currLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("").toUpperCase().replaceAll("Đ", "D").replaceAll("[^a-zA-Z0-9-\" \"]", "");
    }
}