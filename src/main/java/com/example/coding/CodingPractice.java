package com.example.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingPractice {
    public static void main(String[] args) {

        Integer[] numbers = {1,2,4,5,6,7,8,9,9};
        Integer[] numbers2 = {4,7,4,2,9,46,32,23};

//-------------------------------------------------------------------------------------
        // convert Integer array into [int] array
        int[] intArrays = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();

        IntStream.of(intArrays).count();
        IntStream.of(intArrays).sum();
        IntStream.of(intArrays).min().getAsInt();
        IntStream.of(intArrays).max().getAsInt();
        IntStream.of(intArrays).average().getAsDouble();


//------------------------------------------------------------------------------------

        // Convert Integer Array into List
        List<Integer> numberList = Arrays.asList(numbers);
        List<Integer> numberList2 = Arrays.asList(numbers2);

        // count of the arrays
        long count = numberList.stream().count();
        //System.out.println(count);


        // sum of the object array
        Integer sum2 = numberList.stream().reduce(0, (a,b) -> a + b);
        Integer sum = numberList.stream().reduce(0,Integer::sum);
        int sum3 = numberList.stream().collect(Collectors.summingInt(Integer::intValue));

        //System.out.println(sum3);

        // max of the object array
        Integer maxValue = numberList.stream().max(Integer::compareTo).get();
        Integer maxValue2 = numberList.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        // System.out.println(maxValue);

        // min of the array
        Integer min = numberList.stream().min(Comparator.comparingInt(Integer::intValue)).get();
        //System.out.println(min);

        // average of the array
        Double average = numberList.stream().collect(Collectors.averagingDouble(Integer::intValue));
        //System.out.println(average);

        // common elements of two arrays
        List<Integer> commonNumbers = numberList.stream().filter(numberList2::contains).distinct().toList();
        //commonNumbers.forEach(x -> System.out.print(x + ","));

        // combine two arrays and remove duplicates
        Set<Integer> combinedList = Stream.concat(numberList.stream(),numberList2.stream()).collect(Collectors.toSet());
        //combinedList.forEach(System.out::println);

    }
}
