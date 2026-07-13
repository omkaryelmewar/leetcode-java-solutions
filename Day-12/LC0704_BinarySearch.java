/*
 * LeetCode 704 - Binary Search
 *
 * Approach:
 * Use Binary Search to repeatedly divide the search space in half.
 * Compare the middle element with the target and discard the half
 * where the target cannot exist until it is found or the search ends.
 *
 * Time Complexity: O(log n)     // Search space is halved in each iteration
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}