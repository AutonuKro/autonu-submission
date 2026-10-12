class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int [][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        float lastFleet = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            float time = (float)(target - pairs[i][0]) / pairs[i][1];
            if (time > lastFleet) {
                ans += 1;
                lastFleet = time;
            }
        }
        return ans;
    }
}
