package java8.lambda;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;

public class Closure3 {

    public static void main(String[] args) {
        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 42;
        String collect = Arrays.asList("test", "name","aaa").stream().collect(Collectors.joining(",", "begin", "after"));
        System.out.println(collect);
    }

}
