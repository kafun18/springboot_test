package com.example.demo.test.LambdaTest.LambdaJava8;

import java.util.ArrayList;
import java.util.List;

/**
 *  方法引用实例
 */
public class Java8Tester3 {
    public static void main(String args[]){
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
