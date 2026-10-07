class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] max = new int[n - k + 1];

        Deque<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            while (!q.isEmpty() && q.peekFirst() < r - k + 1) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            if (r >= k - 1) {
                max[r - k + 1] = nums[q.peekFirst()];
            }
        }
        return max;
    }
}