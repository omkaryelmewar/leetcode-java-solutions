/*
 * LeetCode 1552 - Magnetic Force Between Two Balls
 *
 * Approach:
 * Sort the basket positions and use Binary Search on the minimum
 * magnetic force (distance) between any two balls. For each candidate
 * distance, greedily place balls as far apart as possible. If all m
 * balls can be placed, try a larger distance; otherwise, reduce it.
 *
 * Time Complexity: O(n log M)   // n = number of positions, M = search range of distances
 * Space Complexity: O(1)        // Constant extra space (excluding sorting)
 */

class Solution {

    // Check if m balls can be placed with at least distance k
    public boolean isPossible(int[] pos, int m, int k) {
        int prev = pos[0];   // Place the first ball
        m--;

        // Try placing the remaining balls
        for (int i = 1; i < pos.length; i++) {
            int val = pos[i];

            // Place a ball if the minimum distance is maintained
            if (val - prev >= k) {
                m--;
                prev = val;
            }

            // All balls have been placed
            if (m == 0) {
                return true;
            }
        }

        return false;
    }

    public int maxDistance(int[] position, int m) {
        // Sort the basket positions
        Arrays.sort(position);

        int l = 1;
        int h = (int) Math.pow(10, 9);

        // Perform Binary Search on the minimum distance
        while (l <= h) {
            int mid = l + (h - l) / 2;

            // Current distance is possible, try a larger one
            if (isPossible(position, m, mid)) {
                l = mid + 1;
            }

            // Reduce the minimum distance
            else {
                h = mid - 1;
            }
        }

        // Maximum possible minimum distance
        return h;
    }
}