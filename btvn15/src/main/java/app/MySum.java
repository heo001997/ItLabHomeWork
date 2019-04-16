package app;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MySum {

    public String sum(String firstStr, String secondStr){
        Integer firstNum = Integer.parseInt(firstStr);
        Integer secondNum = Integer.parseInt(secondStr);
        Integer result = (firstNum + secondNum);
        return String.valueOf(result);
    }
}
