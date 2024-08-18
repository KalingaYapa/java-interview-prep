package com.example;

import java.util.HashMap;
import java.util.Map;

public class LeetCode {
    public static void main(String[] args) {
        //System.out.println(reverse(1534236469));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int reverse(int x) {

        double reverse = 0;
        int temp;
        //System.out.println("MX Int " + Integer.MAX_VALUE);
        while(x != 0) {
            temp = x % 10;
            if(reverse*10 > Integer.MAX_VALUE  || reverse*10 < Integer.MIN_VALUE) {
                return 0;
            }
            //System.out.println("reverse * 10 -> " + reverse*10);
            reverse = reverse*10 + temp;
            //System.out.println("temp ->" + temp + " reverse " + reverse);
            x = x / 10;
        }
        return (int)reverse;
    }

    public static int romanToInt(String s) {
        Map<Character,Integer> m = new HashMap<>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);

        int ans = 0;

        for (int i=0; i < s.length() ; i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
                System.out.println("*i=" + i + ",ans=" + ans);
            } else {
                ans += m.get(s.charAt(i));
                System.out.println("i=" + i + ",ans=" + ans);
            }

        }


        return ans;
    }
}
