/*
 * LeetCode 3659 - Partition Array by GCD Sum
 *
 * Approach:
 * Compute the prefix maximum for the array, then calculate the GCD of
 * each element with its corresponding prefix maximum. Sort the resulting
 * GCD array and pair the smallest and largest values, adding the GCD of
 * each pair to the final answer.
 *
 * Time Complexity: O(n log n)   // Sorting dominates the complexity
 * Space Complexity: O(n)        // Prefix arrays for maximums and GCDs
 */

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;

        // Store the maximum value seen so far for each prefix
        int[] mx = new int[n];
        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            prefixMax = Math.max(prefixMax, nums[i]);
            mx[i] = prefixMax;
        }

        // Compute the GCD of each element with its prefix maximum
        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; ++i) {
            prefixGcd[i] = gcd(nums[i], mx[i]);
        }

        // Sort the GCD values
        Arrays.sort(prefixGcd);

        long ans = 0;
        int left = 0;
        int right = n - 1;

        // Pair the smallest and largest GCD values
        while (left < right) {
            ans += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return ans;
    }

    // Compute the Greatest Common Divisor (GCD)
    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}