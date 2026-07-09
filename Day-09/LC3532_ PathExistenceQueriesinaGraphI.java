/*
 * LeetCode 3532 - Path Existence Queries in a Graph I
 *
 * Approach:
 * Assign a component ID to each index. Adjacent elements whose
 * difference is <= maxDiff belong to the same component.
 * For each query, a path exists if both indices have the
 * same component ID.
 *
 * Time Complexity: O(n + q)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                comp[i] = comp[i - 1];
            } else {
                comp[i] = comp[i - 1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = (comp[u] == comp[v]);
        }

        return ans;
    }
}