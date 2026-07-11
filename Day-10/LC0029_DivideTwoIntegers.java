
/*
 * LeetCode 29 - Divide Two Integers
 *
 * Approach:
 * Repeatedly subtract the largest power-of-two multiple of the divisor
 * from the dividend. Use left shifts to efficiently find the largest
 * multiple that can be subtracted in each step, accumulating the quotient.
 *
 * Time Complexity: O(log² n)    // Nested shifts reduce the dividend each iteration
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {
    public int divide(int dividend, int divisor) {
        // Handle equal numbers
        if (dividend == divisor) return 1;

        // Determine the sign of the result
        boolean sign = true;
        if (dividend >= 0 && divisor < 0) sign = false;
        else if (dividend <= 0 && divisor > 0) sign = false;

        // Convert to positive long values to avoid overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        // Subtract the largest shifted divisor repeatedly
        while (n >= d) {
            int count = 0;

            // Find the maximum power of two multiple
            while (n >= (d << (count + 1))) {
                count++;
            }

            // Add the corresponding power of two to the quotient
            quotient += 1L << count;

            // Reduce the dividend
            n -= (d << count);
        }

        // Handle overflow
        if (quotient == (1L << 31) && sign) {
            return Integer.MAX_VALUE;
        }

        if (quotient == (1L << 31) && !sign) {
            return Integer.MIN_VALUE;
        }

        // Apply the sign and return the result
        return sign ? (int) quotient : (int) -quotient;
    }
}