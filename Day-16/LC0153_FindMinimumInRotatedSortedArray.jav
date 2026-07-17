/*
 * LeetCode 153 - Find Minimum in Rotated Sorted Array
 *
 * Approach:
 * Use Binary Search to locate the minimum element.
 * Compare the middle element with the rightmost element to determine
 * which half contains the minimum, then discard the other half.
 *
 * Time Complexity: O(log n)     // Binary Search halves the search space
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int right = nums.length - 1;
        while (low < right) {
            int mid = low + (right - low) / 2;

            // Minimum lies in the right half
            if (nums[mid] > nums[right]) {
                low = mid + 1;
            }

            // Minimum lies in the left half (including mid)
            else {
                right = mid;
            }
        }

        // 'low' and 'right' point to the minimum element
        return nums[right];
    }
}