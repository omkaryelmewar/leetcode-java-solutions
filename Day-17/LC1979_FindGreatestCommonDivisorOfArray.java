/*
 * LeetCode 1979 - Find Greatest Common Divisor of Array
 *
 * Approach:
 * Find the minimum and maximum elements in the array.
 * The GCD of the entire array is equal to the GCD of its
 * minimum and maximum elements. Compute their GCD using
 * the Euclidean Algorithm.
 *
 * Time Complexity: O(n + log(max))   // Traverse the array and compute GCD
 * Space Complexity: O(1)             // Constant extra space
 */

class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum elements
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Return the GCD of the minimum and maximum values
        return gcd(max, min);
    }

    // Compute the Greatest Common Divisor (GCD)
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}