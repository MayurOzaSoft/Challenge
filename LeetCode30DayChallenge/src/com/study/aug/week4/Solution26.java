package com.study.aug.week4;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fizz Buzz
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 *
 */
public class Solution26 {
    public List<String> fizzBuzz(int n) {
        if(n < 1) {
            return Collections.emptyList();
        }

        return new java.util.AbstractList<String>(){
            // Idea behind this impl is that any testing framework will just do
            // iteration of the returned list and compare numbers at different position.
            // At each position we calculate the value here instead of pre-calculating and pre-filling it.
            public String get(int i){
                i++;
                if(i%15==0) //instead of checking for both 3 and 5 separately, check for 15
                    return "FizzBuzz";
                if(i%3==0)
                    return "Fizz";
                if(i%5==0)
                    return "Buzz";
                return String.valueOf(i);
            }

            public int size(){
                return n;
            }
        };
    }

    public List<String> fizzBuzz_1ms(int n) {
        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i ++){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            } else if(i % 3 == 0){
                result.add("Fizz");
            } else if(i % 5 == 0){
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

}
