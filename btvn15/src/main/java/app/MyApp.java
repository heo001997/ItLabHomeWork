package app;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MyApp {

    public static String firstStr;
    public static String secondStr;

    public static void main(String[] args) {
        try{
            SpringApplication.run(MyApp.class, args);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input first number: ");
            firstStr = scanner.nextLine();
            System.out.println("Input second number: ");
            secondStr = scanner.nextLine();

            MySum mySum = new MySum();
            String result = mySum.sum(firstStr, secondStr);

            System.out.println("The result is: " + result);
        } catch (NumberFormatException e){
            System.out.println("N/A - Please check your input number.");
        }
    }
}
