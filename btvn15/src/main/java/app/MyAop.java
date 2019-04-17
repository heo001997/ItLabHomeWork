package app;

import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAop {

    @Before("execution(* app.MySum.sum(..)) && args(firstStr, secondStr)")
    public void validateBefore(JoinPoint joinPoint, String firstStr, String secondStr){
        if (!(NumberUtils.isParsable(firstStr) && NumberUtils.isParsable(secondStr))){
            throw new NumberFormatException();
        }
    }
}
