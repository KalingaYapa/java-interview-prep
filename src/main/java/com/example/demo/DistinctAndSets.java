package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistinctAndSets {
    public static void main(String[] args) {
        Integer[] intArray = {3,5,3,5,6,7,8,9};
        List<Integer> integerList = Arrays.asList(intArray);

        List<Integer> integerList1 = List.of(3,4,6,7,3,2,3,4,5,7,6,4,3,1,9,0);

        List<Integer> distinctList = integerList1.stream().distinct().toList();

      //  distinctList.forEach(x-> System.out.println("distinct element is " + x));

        Set<Integer> distictSet = distinctList.stream().collect(Collectors.toSet());
        // distictSet.forEach(System.out::println);

        List<String> list1 = List.of("kalinga","kalinga","abc","pqr","ety","ikm","abc");
        List<String> list2 = List.of("abc","821","ksi","ueu","821","kalinga");

        Set<String> commonElement = list1.stream().filter(list2::contains).collect(Collectors.toSet());

        Map<String,Long> x = list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        x.forEach((a,b) -> {
            System.out.println(a + "-" + b);
        });

        commonElement.forEach(System.out::println);



    }
}
