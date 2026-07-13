/*
 * LeetCode 34 - Find First and Last Position of Element in Sorted Array
 *
 * Approach:
 * Perform Binary Search twice:
 * - First search finds the leftmost (first) occurrence of the target.
 * - Second search finds the rightmost (last) occurrence of the target.
 * Return both indices as the answer.
 *
 * Time Complexity: O(log n)     // Two Binary Searches
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {

    static int leftMost(int[] nums, int target) {
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                idx = mid;
                high = mid - 1; // Continue searching on the left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return idx;
    }

    static int rightMost(int[] nums, int target) {
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                idx = mid;
                low = mid + 1; // Continue searching on the right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return idx;
    }

    public int[] searchRange(int[] nums, int target) {

        int left = leftMost(nums, target);
        int right = rightMost(nums, target);

        return new int[]{left, right};
    }
}