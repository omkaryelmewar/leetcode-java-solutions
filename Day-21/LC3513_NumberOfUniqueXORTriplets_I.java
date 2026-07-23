/*
 * LeetCode 3513 - Number of Unique XOR Triplets I
 *
 * Approach:
 * For arrays of size 1 or 2, the number of unique XOR triplets is equal
 * to the array size. For larger arrays, the answer is the smallest power
 * of two that is strictly greater than n, based on the properties of
 * XOR values that can be formed by triplets.
 *
 * Time Complexity: O(log n)     // Find the next power of two
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // Handle arrays with at most two elements
        if (n <= 2) {
            return n;
        }

        int ans = 1;

        // Find the smallest power of two greater than n
        while (ans <= n) {
            ans <<= 1;
        }

        // Return the number of unique XOR triplets
        return ans;
    }
}