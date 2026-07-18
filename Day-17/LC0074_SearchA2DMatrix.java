/*
 * LeetCode 74 - Search a 2D Matrix
 *
 * Approach:
 * Treat the 2D matrix as a flattened sorted array.
 * Use Binary Search on the virtual array and convert each middle index
 * back to its corresponding row and column to access the matrix element.
 *
 * Time Complexity: O(log(n * m))   // Binary Search over all matrix elements
 * Space Complexity: O(1)           // Constant extra space
 */

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int l = 0;
        int h = (n * m) - 1;

        // Perform Binary Search on the virtual 1D array
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Convert the 1D index to 2D coordinates
            int row = mid / m;
            int col = mid % m;

            // Target found
            if (mat[row][col] == target) {
                return true;
            }

            // Search in the right half
            else if (mat[row][col] < target) {
                l = mid + 1;
            }

            // Search in the left half
            else {
                h = mid - 1;
            }
        }

        // Target not found
        return false;
    }
}