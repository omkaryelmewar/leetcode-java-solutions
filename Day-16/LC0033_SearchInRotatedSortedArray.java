/*
 * LeetCode 33 - Search in Rotated Sorted Array
 *
 * Approach:
 * Use Binary Search while determining which half of the array is sorted.
 * If the target lies within the sorted half, continue searching there;
 * otherwise, search the other half. Repeat until the target is found
 * or the search space becomes empty.
 *
 * Time Complexity: O(log n)     // Binary Search halves the search space
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

            // Left half is sorted
            else if (nums[low] <= nums[mid]) {

                // Target lies in the left half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }

                // Search in the right half
                else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies in the right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }

                // Search in the left half
                else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}