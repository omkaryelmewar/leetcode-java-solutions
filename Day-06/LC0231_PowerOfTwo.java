/*
 * LeetCode 231 - Power of Two
 *
 * Approach:
 * Use recursion to repeatedly divide the number by 2.
 * If the number becomes 1, it is a power of two.
 * If the number is 0 or becomes odd (other than 1),
 * it cannot be a power of two, so return false.
 *
 * Time Complexity: O(log n)      // Divide the number by 2 in each recursive call
 * Space Complexity: O(log n)     // Recursive call stack
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
        if(n%2 != 0) return false;
        return isPowerOfTwo(n/2);
    }
}