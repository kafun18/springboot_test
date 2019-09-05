package com.example.demo.test.LambdaTest;

/**
 * 函数式接口(Functional Interfaces)
 */
public class FunctionalInterfaces {
    //大部分函数式接口都不用我们自己写，Java8都给我们实现好了，
    // 这些接口都在java.util.function包里。
    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        // TODO 将数字字符串转换为整数类型
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted.getClass()); //class java.lang.Integer

    }
}

