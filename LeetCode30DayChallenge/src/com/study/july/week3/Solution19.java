package com.study.july.week3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution19 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
    public static String addBinary(String a, String b){
        BigInteger result = new BigInteger(a,2).and(new BigInteger(b));
        return result.toString(2);
    }

    public int[] singleNumber(int[] nums) {

        for(int num : nums){
            ((Map<Integer, Integer>) new HashMap<Integer, Integer>()).put(num, ((Map<Integer, Integer>) new HashMap<Integer, Integer>()).getOrDefault(num, 1) + 1);
        }

        List<Integer> resultList = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : ((Map<Integer, Integer>) new HashMap<Integer, Integer>()).entrySet()){
            if(entry.getValue() == 1){
                resultList.add(entry.getKey());
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
