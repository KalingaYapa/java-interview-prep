package com.example.theroy;

public class Cat implements Printable{
    private int age;
    private String name;

    public Cat() {

    }

    public void meow() {
        System.out.println("Meow");
    }

    // interface implementation

    public void print() {
        System.out.println("Print in cat class");
    }

}
