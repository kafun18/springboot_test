package com.example.demo.test.LambdaTest;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 内置函数式接口(Built-in Functional Interfaces)
 */
public class BuiltFunctionalInterface {

    public static void main(String[] args) {
        //Predicate 接口是只有一个参数的返回布尔类型值的 断言型 接口。
        // 该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");     // "123"
    }
}
