/*
 * LeetCode 540 - Single Element in a Sorted Array
 *
 * Approach:
 * Use Binary Search based on the pairing pattern in the sorted array.
 * Before the single element, pairs start at even indices; after it,
 * pairs start at odd indices. Use this property to narrow the search
 * until the unique element is found.
 *
 * Time Complexity: O(log n)     // Binary Search halves the search space
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Handle edge cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1;
        int high = n - 2;

        // Perform Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Unique element lies in the right half
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) ||
                (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            }

            // Unique element lies in the left half
            else {
                high = mid - 1;
            }
        }

        // This line is never reached for valid inputs
        return -1;
    }
}