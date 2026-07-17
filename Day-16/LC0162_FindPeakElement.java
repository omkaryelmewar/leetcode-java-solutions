/*
 * LeetCode 162 - Find Peak Element
 *
 * Approach:
 * Use Binary Search to locate a peak element.
 * If the middle element is greater than its left neighbor, the peak
 * must lie on the right side (or be the middle element). Otherwise,
 * the peak lies on the left side. Continue until a peak is found.
 *
 * Time Complexity: O(log n)     // Binary Search halves the search space
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Handle edge cases
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int l = 1;
        int h = n - 2;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Peak element found
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Increasing slope, so peak lies on the right
            else if (nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            }

            // Decreasing slope, so peak lies on the left
            else {
                h = mid - 1;
            }
        }

        // This line is never reached for valid inputs
        return -1;
    }
}