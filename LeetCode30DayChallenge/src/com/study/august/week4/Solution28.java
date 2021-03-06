package com.study.august.week4;

import java.util.Random;

/**
 * Implement Rand10() Using Rand7()
 *
 * Given the API rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10. You can only call the API rand7 and you shouldn't call any other API. Please don't use the system's Math.random().
 *
 * Notice that Each test case has one argument n, the number of times that your implemented function rand10 will be called while testing.
 *
 * Follow up:
 *
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: [2]
 *
 * Example 2:
 *
 * Input: n = 2
 * Output: [2,8]
 *
 * Example 3:
 *
 * Input: n = 3
 * Output: [3,8,10]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 *
 */
public class Solution28 {

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     *
     */
    public int rand10() {

        int v1 = rand7(), v2 = rand7();

        while(v1 > 5) v1 = rand7();
        while(v2 == 7) v2 = rand7();

        return (v2 <= 3) ? v1 : v1 + 5;

    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt( 7);
    }
}
