/*
 * LeetCode 3336 - Find the Number of Subsequences With Equal GCD
 *
 * Approach:
 * Use Dynamic Programming where dp[g1][g2] represents the number of ways
 * to build two subsequences whose GCDs are g1 and g2. For each element,
 * consider three choices: skip it, add it to the first subsequence, or
 * add it to the second subsequence. Update the GCDs accordingly and
 * accumulate the valid states. Finally, sum all states where both
 * subsequences have the same non-zero GCD.
 *
 * Time Complexity: O(n * m² * log m)   // m = maximum element, GCD computed for each state
 * Space Complexity: O(m²)              // DP table of GCD states
 */

class Solution {
    static final int MOD = 1000000007;

    public int subsequencePairCount(int[] nums) {

        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            int[][] ndp = new int[m + 1][m + 1];

            for (int j = 0; j <= m; j++) {
                int divisor1 = gcd(j, num);

                for (int k = 0; k <= m; k++) {
                    int val = dp[j][k];
                    if (val == 0) {
                        continue;
                    }

                    int divisor2 = gcd(k, num);

                    ndp[j][k] = (ndp[j][k] + val) % MOD;

                    ndp[divisor1][k] = (ndp[divisor1][k] + val) % MOD;

                    ndp[j][divisor2] = (ndp[j][divisor2] + val) % MOD;
                }
            }

            dp = ndp;
        }

        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans + dp[j][j]) % MOD;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}