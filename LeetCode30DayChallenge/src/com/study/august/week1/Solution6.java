package com.study.august.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6 {
    public List<Integer> findDuplicates_n(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        if (nums.length == 1) return list;

        Arrays.sort(nums);

        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i])
                list.add(nums[i]);
        }

        return list;
    }

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] data = new int[nums.length + 1];

        for (int num : nums)
            data[num]++;

        for (int i = 0; i < data.length; i++)
            if (data[i] == 2) list.add(i);

        return list;
    }
}
