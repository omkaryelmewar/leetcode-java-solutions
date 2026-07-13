/*
 * LeetCode 35 - Search Insert Position
 *
 * Approach:
 * Use Binary Search to find the target in the sorted array.
 * If the target is not found, the final value of 'low' represents
 * the correct index where the target should be inserted.
 *
 * Time Complexity: O(log n)     // Binary Search halves the search space
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // Perform Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Search in the right half
            else if (nums[mid] < target) {
                low = mid + 1;
            }

            // Search in the left half
            else {
                high = mid - 1;
            }
        }

        // Return the insertion position
        return low;
    }
}