public class LC0078_Subsets {
    
}
/*
 * LeetCode 78 - Subsets
 *
 * Approach:
 * Generate all possible subsets using bit manipulation.
 * Each number from 0 to (2^n - 1) represents a subset in binary,
 * where the i-th bit indicates whether nums[i] is included.
 *
 * Time Complexity: O(n * 2^n)   // Check all bits for every subset
 * Space Complexity: O(n * 2^n)  // Store all subsets
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = (1 << n);

        List<List<Integer>> ans = new ArrayList<>();

        // Generate all subset masks
        for (int num = 0; num < subsets; num++) {
            List<Integer> lst = new ArrayList<>();

            // Check each bit of the current mask
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    lst.add(nums[i]);
                }
            }

            // Add the current subset to the answer
            ans.add(lst);
        }

        return ans;
    }
}