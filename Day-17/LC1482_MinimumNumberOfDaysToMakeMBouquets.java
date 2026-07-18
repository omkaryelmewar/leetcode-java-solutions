/*
 * LeetCode 1482 - Minimum Number of Days to Make m Bouquets
 *
 * Approach:
 * Use Binary Search on the number of days.
 * For each candidate day, count how many bouquets of size k can be made
 * using consecutive flowers that have bloomed. If at least m bouquets
 * can be formed, try fewer days; otherwise, increase the number of days.
 *
 * Time Complexity: O(n log M)   // n = number of flowers, M = maximum bloom day
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {

    // Check if m bouquets can be made by the given day
    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int took = 0;

        // Traverse all flowers
        for (int i = 0; i < bloomDay.length; i++) {

            // Flower has bloomed
            if (bloomDay[i] <= day) {
                took++;
            }

            // Sequence breaks
            else {
                took = 0;
            }

            // One bouquet is formed
            if (took == k) {
                m--;
                took = 0;
            }

            // Required bouquets are formed
            if (m == 0) {
                return true;
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1;
        int r = (int) Math.pow(10, 9);

        // Perform Binary Search on the number of days
        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Current day is sufficient, try fewer days
            if (isPossible(bloomDay, m, k, mid)) {
                r = mid - 1;
            }

            // Need more days
            else {
                l = mid + 1;
            }
        }

        // Impossible to make the required bouquets
        int limit = (int) Math.pow(10, 9);
        if (l == limit + 1) {
            return -1;
        }

        // Minimum number of days required
        return l;
    }
}