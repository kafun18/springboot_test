package com.example.demo.test.LambdaTest;

/**
 * 方法和构造函数引用(Method and Constructor References)
 */
public class MethodConstructor {
    //大部分函数式接口都不用我们自己写，Java8都给我们实现好了，
    // 这些接口都在java.util.function包里。
    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        //还可以通过静态方法引用来表示
        FunctionalInterfaces.Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter1.convert("123");
        System.out.println(converted1.getClass());   //class java.lang.Integer

        //Java 8允许您通过::关键字传递方法或构造函数的引用.
        // 上面的示例显示了如何引用静态方法。但我们也可以引用对象方法：
        Something something = new Something();
        //上面有@FunctionalInterface声明可以不用加FunctionalInterface.
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);    // "J"

        //这里我们使用构造函数引用来将他们关联起来，
        // 而不是手动实现一个完整的工厂：
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

//接下来看看构造函数是如何使用::关键字来引用的，
// 首先我们定义一个包含多个构造函数的简单类：
class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

//接下来我们指定一个用来创建Person对象的对象工厂接口
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
