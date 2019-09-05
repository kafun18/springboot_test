package com.example.demo.test.LambdaTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式(Lambda expressions)
 */
public class LambdaExpressions {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        List<String> names1 = Arrays.asList("6", "9", "1", "3");

        /**
         * 老版本的Java中是如何排列字符串
         */
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {

//                升序排的话就是第一个参数.compareTo(第二个参数);
//                降序排的话就是第二个参数.compareTo(第一个参数);
//                按首字母升序排
                return b.compareTo(a);
            }
        });
        System.out.println(names1);

        /**
         * Java 8提供了更简洁的语法
         */
        Collections.sort(names1, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names1);

        /**
         * Java 8提供了更简洁的语法(简单)
         */
        Collections.sort(names1, (String a, String b) -> b.compareTo(a));

        /**
         * Java 8提供了更简洁的语法(更简单)
         */
        names1.sort((a, b) -> b.compareTo(a));

    }
}
