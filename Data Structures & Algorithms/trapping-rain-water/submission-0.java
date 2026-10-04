class Solution {
    public int trap(int[] height) {
        int n = height.length,  maxLeft[] = new int[n], maxRight[] = new int[n];
        int curr = height[0];
        for(int i = 1; i < n; i++) {
            maxLeft[i] = max(height[i - 1], curr);
            curr = maxLeft[i];
        }
        curr = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            maxRight[i] = max(height[i+1], curr);
            curr = maxRight[i];
        }
        int water = 0;
        for(int i = 0; i < n; i++) {
            water += max(0, (min(maxLeft[i], maxRight[i]) - height[i]));
        }
        return water;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
