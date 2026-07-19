/*
 * LeetCode 1081 - Smallest Subsequence of Distinct Characters
 *
 * Approach:
 * Use a monotonic stack to build the lexicographically smallest result.
 * Track the last occurrence of each character and whether it is already
 * present in the stack. Before pushing a character, remove larger
 * characters from the stack if they appear again later.
 *
 * Time Complexity: O(n)         // Each character is pushed and popped at most once
 * Space Complexity: O(1)        // Fixed-size arrays and stack (26 lowercase letters)
 */

class Solution {
    public String smallestSubsequence(String s) {

        // Store the last occurrence index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Track whether a character is already in the stack
        boolean[] vis = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // Process each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Skip if the character is already included
            if (vis[ch - 'a']) {
                continue;
            }

            // Remove larger characters that appear again later
            while (!stack.isEmpty()
                    && stack.peek() > ch
                    && lastIndex[stack.peek() - 'a'] > i) {

                vis[stack.pop() - 'a'] = false;
            }

            // Add the current character
            stack.push(ch);
            vis[ch - 'a'] = true;
        }

        // Build the final answer
        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}