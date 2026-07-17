/*
 * LeetCode 69 - Sqrt(x)
 *
 * Approach:
 * Use Binary Search to find the largest integer whose square is less
 * than or equal to x. Keep updating the answer whenever a valid square
 * is found and continue searching on the right for a larger value.
 *
 * Time Complexity: O(log x)     // Binary Search halves the search space
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int mySqrt(int x) {

        // Handle small values
        if (x == 0 || x == 1) {
            return x;
        }

        int low = 1;
        int high = x;
        int ans = 1;

        // Perform Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Mid is a valid square root candidate
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            }

            // Search in the left half
            else {
                high = mid - 1;
            }
        }

        // Return the floor of the square root
        return ans;
    }
}