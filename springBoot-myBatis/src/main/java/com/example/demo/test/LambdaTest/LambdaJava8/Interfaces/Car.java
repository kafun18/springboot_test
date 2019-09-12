package com.example.demo.test.LambdaTest.LambdaJava8.Interfaces;

import java.util.Arrays;
import java.util.List;

/**
 * 方法引用
 */
class Car {
    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        System.out.println(1);

        //静态方法引用：它的语法是Class::static_method
        cars.forEach(Car::collide);
        System.out.println(2);

        //特定类的任意对象的方法引用：它的语法是Class::method
        cars.forEach(Car::repair);
        System.out.println(3);

        //特定对象的方法引用：它的语法是instance::method
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}

