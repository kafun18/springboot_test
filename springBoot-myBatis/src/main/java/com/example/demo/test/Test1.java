package com.example.demo.test;

import java.text.NumberFormat;

public class Test1 {
    public static void main(String[] args) {
        int number = 1;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(7);
        formatter.setGroupingUsed(false);
        String s = formatter.format(number);
        s=s+1;
        System.out.println(s);

    }


}
