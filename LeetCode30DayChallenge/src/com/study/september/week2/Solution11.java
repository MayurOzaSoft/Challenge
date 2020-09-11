package com.study.september.week2;

/**
 * Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class Solution11 {
    public int maxProduct(int[] nums){
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int num : nums) {
            product *= num;
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) product = 1;
        }

        product = 1;
        for(int i = nums.length - 1; i >= 0; i --){
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if(product == 0) product = 1;
        }

        return maxProduct;
    }

    public int maxProduct_1ms(int[] nums) {
        if(nums.length == 0) return 0;

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];

        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > 0){
                max[i] = Math.max(nums[i], max[i-1]*nums[i]);
                min[i] = Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i] = Math.max(nums[i], min[i-1]*nums[i]);
                min[i] = Math.min(nums[i], max[i-1]*nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }
}
