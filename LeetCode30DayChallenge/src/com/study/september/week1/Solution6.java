package com.study.september.week1;

/**
 * Image Overlap
 *
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 *
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 *
 */
public class Solution6 {

    public int largestOverlap_45ms(int[][] A, int[][] B) {
        int largestOverlap = 0;
        for(int row = -A.length + 1; row < A.length; row ++)
            for(int col = -A.length + 1; col < A.length; col ++)
                largestOverlap = Math.max(largestOverlap, largestOnes(A, B, row, col));

        return largestOverlap;
    }

    public int largestOnes(int[][] A, int[][] B, int rowOff, int colOff){
        int count = 0;

        for(int row = 0; row < A.length; row ++){
            for(int col = 0; col < A[0].length; col ++){

                if( ((row + rowOff) < 0 || (row + rowOff) >= A.length) ||
                        ((col + colOff) < 0 || (col + colOff) >= A[0].length) )
                    continue;

                if(A[row][col] + B[row + rowOff][col + colOff] == 2)
                    count ++;

            }

        }

        return count;
    }

    protected int convolute(int[][] A, int[][] kernel, int xShift, int yShift) {
        int result = 0;
        for (int row = 0; row < A.length; ++row)
            for (int col = 0; col < A.length; ++col)
                result += A[row][col] * kernel[row + yShift][col + xShift];
        return result;
    }

    public int largestOverlap_32ms(int[][] A, int[][] B) {

        int N = A.length;
        int[][] B_padded = new int[3 * N - 2][3 * N - 2];
        for (int row = 0; row < N; ++row)
            System.arraycopy(B[row], 0, B_padded[row + N - 1], N - 1, N);

        int maxOverlaps = 0;
        for (int xShift = 0; xShift < 2 * N - 1; ++xShift)
            for (int yShift = 0; yShift < 2 * N - 1; ++yShift) {
                maxOverlaps = Math.max(maxOverlaps,
                        convolute(A, B_padded, xShift, yShift));
            }

        return maxOverlaps;
    }

    protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int count = 0;
        int rRow = 0;
        // count the cells of ones in the overlapping zone.
        for (int mRow = yShift; mRow < M.length; ++mRow) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; ++mCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    count += 1;
                rCol += 1;
            }
            rRow += 1;
        }
        return count;
    }

    public int largestOverlap_16ms(int[][] A, int[][] B) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < A.length; ++yShift)
            for (int xShift = 0; xShift < A.length; ++xShift) {
                // move one of the matrices up and left and vice versa.
                // (equivalent to move the other matrix down and right)
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
            }

        return maxOverlaps;
    }
}
