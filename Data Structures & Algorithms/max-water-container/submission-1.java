class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int maxArea = 0;
        while (l < r) {
            int a = min(h[l], h[r]);
            int b = r - l;
            int area = a * b;
            maxArea = max(maxArea, area);
            if (h[l] < h[r]) l += 1;
            else r -= 1;
        }
        return maxArea;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
    
    static int min(int a, int b) {
        return a < b ? a : b;
    }

}
