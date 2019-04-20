package com.topica.vn.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicLambda {
    static List<String> stringList;
    static List<Integer> integerList;

    public static void main(String[] args) {
        stringList = Arrays.asList("one", "two", "three", "four", "one", "two");
        integerList = Arrays.asList(1, 2, 3, 4, 1, 2);

        // sum easy
        System.out.println("Sum is: " + integerList.parallelStream().mapToInt(i -> i).sum());

        // max
        System.out.println("Max is: " + (integerList.parallelStream().mapToInt(i -> i).max()).getAsInt());

        // min
        System.out.println("Min is: " + (integerList.parallelStream().mapToInt(i -> i).min()).getAsInt());

        // sum optimized for streams and multithreaded environment
        LongAdder a = new LongAdder();
        integerList.parallelStream().forEach(a::add);
        System.out.println("Sum optimized is: " + a.intValue());

        // group
        System.out.println(
                "Grouping result is: " +
                stringList.parallelStream().collect(
                        Collectors.groupingBy(Function.identity())
                )
        );

        // count
        System.out.println(
                "Counting result is: " +
                stringList.parallelStream().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                )
        );

        // filter
        System.out.println("Filter result is: " + stringList.parallelStream().filter(line -> !"one".equals(line)).collect(Collectors.toList()));
    }
}
