/*
 * LeetCode 1011 - Capacity To Ship Packages Within D Days
 *
 * Approach:
 * Use Binary Search on the ship's capacity.
 * For each candidate capacity, simulate loading the packages in order.
 * If all packages can be shipped within the given number of days, try
 * a smaller capacity; otherwise, increase the capacity.
 *
 * Time Complexity: O(n log M)   // n = number of packages, M = search range of capacities
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {

    // Check if all packages can be shipped with capacity k
    public boolean isPossible(int[] weights, int days, int k) {
        int currentLoad = 0;

        // Traverse all packages
        for (int i = 0; i < weights.length; i++) {
            int val = weights[i];

            // A single package exceeds the capacity
            if (val > k) {
                return false;
            }

            // Start a new day if the current package cannot fit
            if (currentLoad + val > k) {
                days--;
                currentLoad = 0;
            }

            currentLoad += val;

            // No days remaining
            if (days == 0) {
                return false;
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int h = Integer.MAX_VALUE;

        // Perform Binary Search on the ship capacity
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Current capacity is sufficient, try a smaller one
            if (isPossible(weights, days, mid)) {
                h = mid - 1;
            }

            // Increase the ship capacity
            else {
                l = mid + 1;
            }
        }

        // Minimum capacity required
        return l;
    }
}