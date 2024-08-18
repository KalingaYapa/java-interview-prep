package com.example.theroy;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MyMainClass {

    private int age;
    private String name;

    private static int catCount = 0;

    public MyMainClass() {
        catCount++;
    }

    public void meow() {
        System.out.println("Cat Meow -> " + name + catCount);
    }

    public static void catCount() {
        System.out.println(catCount);
    }

    public static void main(String args[]) {
        MyMainClass.catCount();
        MyMainClass cat1 = new MyMainClass();
        cat1.age = 13;
        cat1.name = "kitty";
        cat1.meow();
        MyMainClass.catCount();

        Predicate<String> myPredicate = (x) -> x.startsWith("o");
        System.out.println(myPredicate.test("kalinga"));

        Supplier<String> mySuplier = (() ->  "hello suplier");
        System.out.println(mySuplier.get());

        Function<String, Integer> myFunction = (x) -> x.length();
        System.out.println(myFunction.apply("kalinga"));

        Consumer<String> myConsumer = (x) -> System.out.println(x);
        myConsumer.accept("hello Kalinga");

    }
}
