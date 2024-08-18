package com.example.coding;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamCoding {

    public static void main(String[] args) {

        int[] numbers = {34,2,4,21,67,43,21,89,54};
        // convert int[] in to Integer[] or List
        Integer[] integerObjectArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        List<Integer> integerList = Arrays.stream(numbers).boxed().toList();
        List<Integer> integerList1 = Arrays.asList(integerObjectArray);

        // convert Integer[] array into int[] array
        int[] intArrays = Arrays.stream(integerObjectArray).mapToInt(Integer::intValue).toArray();

        // get second largest element

        int secondLarge = Arrays.stream(numbers).boxed().sorted((a,b) -> b-a).skip(1)
                .mapToInt(Integer::intValue)
                .findFirst().getAsInt();

        IntStream.of(numbers).boxed().sorted((a,b) -> b-a).skip(1).findFirst();

        // get max
        int max = IntStream.of(numbers).max().getAsInt();
       // System.out.println(max);

        // get min
        int min = IntStream.of(numbers).min().getAsInt();
       // System.out.println(min);

        // get sum
        int sum = IntStream.of(numbers).sum();
        // System.out.println(sum);

        // range
       // IntStream.range(1,5).map(n -> n * n).forEach(System.out::println);

        // range close
        //IntStream.rangeClosed(1,5).map(n -> n*n).forEach(System.out::println);

        // average
        double average = IntStream.of(numbers).average().getAsDouble();
       // System.out.println(average);

        long startTime = System.currentTimeMillis();

        System.out.println("start time -> " + startTime);

        int rangeSum = IntStream.range(1,1000000)
                .map(n->n*n)
                .sum();

        System.out.println(rangeSum);

        long endTime = System.currentTimeMillis();

        System.out.println("end time -> " + endTime);
        System.out.println("Time Taken in millis -> " + (endTime - startTime));

        startTime = System.currentTimeMillis();

        System.out.println("start time -> " + startTime);

        int rangeSumParallel = IntStream.range(1,1000000)
                .parallel()
                .map(n->n*n)
                .sum();

        System.out.println(rangeSumParallel);

        endTime = System.currentTimeMillis();

        System.out.println("end time -> " + endTime);
        System.out.println("Time Taken in millis -> " + (endTime - startTime));
    }



}
