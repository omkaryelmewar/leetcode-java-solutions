/*
 * LeetCode 875 - Koko Eating Bananas
 *
 * Approach:
 * Use Binary Search on the eating speed k.
 * For each candidate speed, calculate the total hours required to eat
 * all banana piles. If Koko can finish within h hours, try a smaller
 * speed; otherwise, increase the speed.
 *
 * Time Complexity: O(n log m)   // n = number of piles, m = maximum pile size
 * Space Complexity: O(1)        // Constant extra space
 */

class Solution {

    // Check if Koko can finish all bananas at speed k within h hours
    public boolean isPossible(int[] piles, int h, int k) {
        for (int i = 0; i < piles.length; i++) {

            // Hours needed for the current pile
            int val = piles[i] / k;
            if (piles[i] % k != 0) {
                val++;
            }

            h -= val;

            // Not enough hours remaining
            if (h < 0) {
                return false;
            }
        }

        return true;
    }

    // Find the maximum pile size
    public int findMax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        // Perform Binary Search on the eating speed
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Current speed is sufficient, try a smaller speed
            if (isPossible(piles, h, mid)) {
                high = mid - 1;
            }

            // Increase the eating speed
            else {
                low = mid + 1;
            }
        }

        // Minimum possible eating speed
        return low;
    }
}