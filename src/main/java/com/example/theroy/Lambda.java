package com.example.theroy;

public class Lambda {
    public static void main(String args[]) {
        Cat cat = new Cat();
       // Step 01:: old approach
            // print(cat);

        // Step 02 ::
        // instead of the parsing object , we are parsing the implementation only
      /*  print (
            public void print() {
                System.out.println("Print in cat class");
            }
        ); */

        // we are simplifying it to align with lambda
        // lambda annotations -> Lambda contains the implementation of functional interface SAM
        Printable p = () -> System.out.println("Print in cat class");
        print(p);
    }

    public static void print(Printable printable) {
        printable.print();
    }

}
