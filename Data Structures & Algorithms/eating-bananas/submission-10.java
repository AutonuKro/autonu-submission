class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int low = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHrs = 0;

            for (int pile : piles) {
                totalHrs += (pile + mid - 1) / mid;

                if (totalHrs > h) {
                    break; // Fail fast
                }
            }

            if (totalHrs <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}