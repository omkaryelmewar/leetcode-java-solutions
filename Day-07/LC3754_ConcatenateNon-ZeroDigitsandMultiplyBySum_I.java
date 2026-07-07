/*
 * LeetCode 3754: Concatenate Non-Zero Digits and Multiply by Sum I
 *
 * Approach:
 * Traverse each digit of the given number from right to left.
 * Ignore all zero digits. For every non-zero digit, add it to the
 * digit sum and simultaneously construct a new number containing
 * only the non-zero digits in their original order. Finally,
 * return the product of the digit sum and the newly formed number.
 *
 * Time Complexity: O(d)         // Traverse all digits once
 * Space Complexity: O(1)        // Uses only a few extra variables
 */

class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long sum = 0;
        int i = 0;
        while(n > 0){
            int rem = n % 10;
            if(rem != 0){
                sum += rem;
                num += (long)(Math.pow(10,i)) * rem;
                i++;
            }
            n = n/10;
        }
        return sum * num;
    }
}