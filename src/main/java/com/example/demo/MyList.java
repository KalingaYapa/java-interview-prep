package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    public static void main(String args[]) {
        List<String> myList = new ArrayList<>();
        myList.add("");
        myList.add(" ");
        myList.add("kalinga");
        myList.add("kalinga");
        myList.add(null);
        myList.add(null);

        System.out.println(myList  + " size is -> " + myList.size());
    }
}
