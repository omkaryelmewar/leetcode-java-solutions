/*
 * LeetCode 3658 - GCD of Odd and Even Sums
 *
 * Approach:
 * The sum of the first n odd numbers is n² and the sum of the first n
 * even numbers is n(n + 1). The GCD of these two sums simplifies to n.
 * Therefore, the answer is simply n.
 *
 * Time Complexity: O(1)         // Constant time computation
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int gcdOfOddEvenSums(int n) {

        // GCD(n², n(n + 1)) = n
        return n;
    }
}