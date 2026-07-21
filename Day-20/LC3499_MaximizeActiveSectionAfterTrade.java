/*
 * LeetCode 3499 - Maximize Active Section After Trade
 *
 * Approach:
 * Count the number of active ('1') sections in the string.
 * Traverse the string by grouping consecutive identical characters.
 * For each block of '0's, compute its length and combine it with the
 * previous '0' block to determine the maximum gain obtainable after
 * a single trade. Add the best gain to the initial count of active
 * sections.
 *
 * Time Complexity: O(n)         // Single traversal of the string
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        // Count the initially active sections
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt1++;
            }
        }

        int i = 0;
        int bestGain = 0;
        int prev = Integer.MIN_VALUE;
        int cur = 0;

        // Traverse consecutive blocks of identical characters
        while (i < n) {
            int start = i;

            // Find the end of the current block
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }

            // Process each block of '0's
            if (s.charAt(start) == '0') {
                cur = i - start;

                // Update the maximum gain by combining adjacent zero blocks
                if (prev != Integer.MIN_VALUE) {
                    bestGain = Math.max(bestGain, prev + cur);
                }

                prev = cur;
            }
        }

        // Return the maximum active sections after one trade
        return cnt1 + bestGain;
    }
}