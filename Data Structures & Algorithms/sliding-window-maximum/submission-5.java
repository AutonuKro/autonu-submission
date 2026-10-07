class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n-k+1];
        Integer [] pair;
        Queue<Integer[]> q = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        for(int l = 0, r = 0; r < n; r++){
            q.add(new Integer[]{nums[r], r});
            if(r - l + 1 == k) {
                Integer []p = q.poll();
                while(p[1] < l){
                    p = q.poll();
                }
                max[l] = nums[p[1]];
                q.add(p);
                l++;
            }
        }
        return max;
    }
}
