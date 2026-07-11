/*
 * LeetCode 260 - Single Number III
 *
 * Approach:
 * XOR all elements to get x ^ y, where x and y are the two unique numbers.
 * Find the rightmost set bit in the XOR result to separate the numbers into
 * two groups. XOR each group separately to cancel out duplicate numbers,
 * leaving the two unique elements.
 *
 * Time Complexity: O(n)         // Two passes through the array
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        long ans = 0;

        // XOR all numbers to get x ^ y
        for (int num : nums) {
            ans ^= num;
        }

        // Find the rightmost set bit
        long rightmost = (ans & (ans-1)) ^ ans;

        int bucket1 = 0;
        int bucket2 = 0;

        // Divide numbers into two groups based on the rightmost set bit
        for (int num : nums) {
            if ((num & rightmost) != 0) {
                bucket1 ^= num;
            } else {
                bucket2 ^= num;
            }
        }

        // Return the two unique numbers
        return new int[]{bucket1, bucket2};
    }
}