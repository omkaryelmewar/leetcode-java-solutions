/*
 * LeetCode 374 - Guess Number Higher or Lower
 *
 * Approach:
 * Use Binary Search to guess the hidden number.
 * Based on the result of the guess API, discard half of the search
 * space until the correct number is found.
 *
 * Time Complexity: O(log n)     // Binary Search halves the range each step
 * Space Complexity: O(1)        // Constant extra space
 */

public class LC0374_GuessNumberHigherToLower extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (guess(mid) == 0) {
                return mid;
            }
            else if (guess(mid) == 1) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}