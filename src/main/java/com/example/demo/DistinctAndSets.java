package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctAndSets {
    public static void main(String[] args) {
        Integer[] intArray = {3,5,3,5,6,7,8,9};
        List<Integer> integerList = Arrays.asList(intArray);

        List<Integer> integerList1 = List.of(3,4,6,7,3,2,3,4,5,7,6,4,3,1,9,0);

        List<Integer> distinctList = integerList1.stream().distinct().toList();

        distinctList.forEach(x-> System.out.println("distinct element is " + x));

        Set<Integer> distictSet = distinctList.stream().collect(Collectors.toSet());
        distictSet.forEach(System.out::println);
    }
}
