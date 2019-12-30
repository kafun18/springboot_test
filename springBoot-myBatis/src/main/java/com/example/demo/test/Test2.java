package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        List<Map<String,Object>> l = new ArrayList<>();
        System.out.println(l);

        if (l.size()!=0){
            System.out.println("不为空");
        }else {
            System.out.println("为空");
        }
    }
}
