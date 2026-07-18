/*
 * LeetCode 240 - Search a 2D Matrix II
 *
 * Approach:
 * Start from the top-right corner of the matrix.
 * If the current element is greater than the target, move left.
 * If it is smaller than the target, move down.
 * Continue until the target is found or the search goes out of bounds.
 *
 * Time Complexity: O(n + m)     // At most one pass across rows and columns
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int row = 0;
        int col = m - 1;

        // Start searching from the top-right corner
        while (row < n && col >= 0) {

            // Target found
            if (mat[row][col] == target) {
                return true;
            }

            // Move down if the current element is smaller
            else if (mat[row][col] < target) {
                row++;
            }

            // Move left if the current element is larger
            else {
                col--;
            }
        }

        // Target not found
        return false;
    }
}