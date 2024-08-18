package com.example.demo;
import java.util.*;
public class MySorting {
    public static void main(String args[]) {
        List<Integer> nums = new ArrayList<>();
        nums.add(23);
        nums.add(65);
        nums.add(11);
        nums.add(54);
        nums.add(17);

        System.out.println(nums);
        Collections.sort(nums,(i,j) -> i%10 > j%10 ? 1 : -1);
        System.out.println(nums);
    }
}
