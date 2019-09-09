package com.example.demo.test.LambdaTest;

/**
 * Lambda Scopes
 * Lamda 表达式作用域
 *
 */
public class LambdaScopes {

    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        //访问局部变量
        //但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确
//        final int num = 1;
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String s = stringConverter.convert(2);
        System.out.println(s);

//        num = 3;//在lambda表达式中试图修改num同样是不允许的。

    }
}

/**
 * 访问字段和静态变量
 */
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        LambdaScopes.Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        LambdaScopes.Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}
