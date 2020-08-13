package com.study.aug.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution12 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex];
        Arrays.fill(result, 0);

        result[0] = 1;

        for(int i = 0; i < rowIndex; i ++){
            for(int j = i; j > 0; j --){
                result[j] += result[j - 1];
            }
        }

        return Arrays.asList(result);
    }

    public List<Integer> getRow_n(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();

        if (rowIndex < 0)
            return result;

        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }

        return result;
    }
}
