package com.study.september.week1;

/**
 * Largest Time for Given Digits
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 *
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 *
 */
public class Solution1 {
    int[] result;

    public String largestTimeFromDigits(int[] nums) {
        permutate(nums, 0);
        return format(result);
    }

    private void permutate(int[] nums, int offset) {
        if (offset == nums.length - 1) {
            if (isValid(nums) && isBetter(result, nums)) {
                if (result == null) {
                    result = new int[4];
                }
                System.arraycopy(nums, 0, result, 0, 4);
            }
            return;
        }

        for (int i = offset; i < nums.length; i++) {
            int tmp = nums[offset];
            nums[offset] = nums[i];
            nums[i] = tmp;
            permutate(nums, offset + 1);
            nums[i] = nums[offset];
            nums[offset] = tmp;
        }

    }

    private boolean isValid(int[] nums) {
        return nums[0] <= 2
                && (nums[0] != 2 || nums[1] <= 3)
                && nums[2] <= 5;
    }

    private boolean isBetter(int[] result, int[] nums) {
        if (result == null) {
            return true;
        }
        for(int i = 0; i < 3; i++) {
            if (result[i] == nums[i]) {
                continue;
            }
            return result[i] < nums[i];
        }
        return false;
    }

    private String format(int[] nums) {
        if (nums == null) {
            return "";
        } else {
            return String.valueOf(nums[0]) +
                    nums[1] +
                    ':' +
                    nums[2] +
                    nums[3];
        }
    }

    public String largestTimeFromDigits_37ms(int[] A) {
        int[] ans = new int[]{-1};
        timeDfs(A, ans, 0, 0, new boolean[A.length]);
        if (ans[0] == -1) {
            return "";
        }
        return getRes(ans[0]);
    }

    private String getRes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }

    private void timeDfs(int[] A, int[] ans, int num, int count, boolean[] used) {
        if (count == A.length) {
            ans[0] = Math.max(ans[0], num);
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                int cal = num * 10 + A[i];
                if (count == 1 && (cal < 0 || cal >= 24)) {
                    continue;
                }
                if (count == 3 && (cal % 100 < 0 || cal % 100 >= 60)) {
                    continue;
                }
                used[i] = true;
                timeDfs(A, ans, cal, count + 1, used);
                used[i] = false;
            }
        }
    }
}
