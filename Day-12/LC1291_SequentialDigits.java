/*
 * LeetCode 1291 - Sequential Digits
 *
 * Approach:
 * Use the string "123456789" to generate all possible sequential numbers.
 * Create substrings of lengths between the number of digits in low and high.
 * Convert each substring to an integer and add it to the result if it lies
 * within the given range.
 *
 * Time Complexity: O(1)         // At most 36 sequential numbers are generated
 * Space Complexity: O(1)        // Extra space excluding the output list
 */

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";

        // Determine the minimum and maximum digit lengths
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();

        List<Integer> ans = new ArrayList<>();

        // Generate sequential numbers of each possible length
        for (int i = minLen; i <= maxLen; i++) {

            // Generate all substrings of the current length
            for (int start = 0; start + i <= 9; start++) {
                String subStr = s.substring(start, start + i);
                int num = Integer.parseInt(subStr);

                // Add numbers within the given range
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}