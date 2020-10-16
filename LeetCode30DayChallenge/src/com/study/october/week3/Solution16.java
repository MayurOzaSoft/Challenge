package com.study.october.week3;

import java.util.Arrays;

/**
 * Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 * Example 2:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 * Example 3:
 *
 * Input: matrix = [], target = 0
 * Output: false
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 0 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 */
public class Solution16 {
    public boolean searchMatrix_inBuildMethod(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix.length == 1) return Arrays.binarySearch(matrix[0], target) >= 0;

        for (int[] row : matrix) {
            int rowLength = row.length;
            if(row[rowLength - 1] > target)
                return Arrays.binarySearch(row, target) >= 0;
        }

        return false;
    }

    public boolean searchMatrix_mostPreferred(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }

}

