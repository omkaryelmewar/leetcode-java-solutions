/*
 * LeetCode 1260 - Shift 2D Grid
 *
 * Approach:
 * Treat the 2D grid as a flattened 1D array.
 * Compute the new position of each element after shifting by k places,
 * then convert the new index back to 2D coordinates and place the
 * element in the result grid.
 *
 * Time Complexity: O(m * n)     // Visit every cell once
 * Space Complexity: O(m * n)    // Result grid to store shifted elements
 */

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k %= total;

        List<List<Integer>> ans = new ArrayList<>();

        // Initialize the result grid with zeros
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        // Shift each element to its new position
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Convert 2D index to 1D index
                int oldIndex = i * n + j;

                // Compute the new 1D index after shifting
                int newIndex = (oldIndex + k) % total;

                // Convert the new 1D index back to 2D coordinates
                int newRow = newIndex / n;
                int newCol = newIndex % n;

                // Place the element in its new position
                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ans;
    }
}