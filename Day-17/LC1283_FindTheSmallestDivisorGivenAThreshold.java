/*
 * LeetCode 1283 - Find the Smallest Divisor Given a Threshold
 *
 * Approach:
 * Use Binary Search on the divisor.
 * For each candidate divisor, compute the sum of the ceiling values of
 * nums[i] / divisor. If the sum is within the threshold, try a smaller
 * divisor; otherwise, increase the divisor.
 *
 * Time Complexity: O(n log m)   // n = array size, m = maximum element
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {

    // Check if the current divisor satisfies the threshold
    public boolean isPossible(int[] nums, int threshold, int k) {
        for (int i = 0; i < nums.length; i++) {

            // Compute ceil(nums[i] / k)
            int val = nums[i] / k;
            if (nums[i] % k != 0) {
                val++;
            }

            threshold -= val;

            // Threshold exceeded
            if (threshold < 0) {
                return false;
            }
        }

        return true;
    }

    // Find the maximum element in the array
    public int findMax(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = findMax(nums);

        // Perform Binary Search on the divisor
        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Current divisor is valid, try a smaller one
            if (isPossible(nums, threshold, mid)) {
                r = mid - 1;
            }

            // Increase the divisor
            else {
                l = mid + 1;
            }
        }

        // Smallest valid divisor
        return l;
    }
}