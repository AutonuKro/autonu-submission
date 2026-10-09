class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for(int l = 0; l < temperatures.length; l++) {
            int r = l + 1;
            while(r < temperatures.length &&  temperatures[l] >= temperatures[r]) {
                r++;
            }
            if(r < temperatures.length && temperatures[l] < temperatures[r])
                ans[l] = r - l;
        }
        return ans;
    }
}
