class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while(!s.isEmpty() && t > s.peek()[0]) {
                int[] p = s.pop();
                ans[p[1]] = i - p[1];
            }
            s.push(new int[]{t, i});
        }
        // int[] ans = new int[temperatures.length];
        // for(int l = 0; l < temperatures.length; l++) {
        //     int r = l + 1;
        //     while(r < temperatures.length &&  temperatures[l] >= temperatures[r]) {
        //         r++;
        //     }
        //     if(r < temperatures.length && temperatures[l] < temperatures[r])
        //         ans[l] = r - l;
        // }
        return ans;
    }
}
