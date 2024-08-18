package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MySet {
    public static void main(String args[]) {
        Set<String> myStringSet = new HashSet<String>();
        myStringSet.add("");
        myStringSet.add(" ");
        myStringSet.add("kalinga");
        myStringSet.add(null);
        myStringSet.add("kalinga");

        System.out.println(myStringSet  + " -> size " + myStringSet.size());
    }
}
