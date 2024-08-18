package com.example.theroy;

public class StaticClassExample {
    int x;
    public void printString() {
        System.out.println("Print Strinhg");
    }

    public static void printStaticMethod() {
        System.out.println("Static Print Method");
    }

    static class MyStatic {
        public void innerClassPrintMethod() {
            System.out.println("Inner Class non static Print Method");
        }

        public static void innerClassStaticPrintMethod() {
            System.out.println("Inner class static block");
        }

    }
}
