class Solution {
    public int trap(int[] height) {
        // This space complexity = O(1);
        // Space complexity = O(N) where N = sizeof(height);
        int n = height.length, left = 0, right = n - 1;
        int currMaxLeft = height[0], currMaxRight = height[n-1];
        int water = 0;
        while(left < right) {
            if(currMaxLeft < currMaxRight) {
                left += 1;
                currMaxLeft = max(currMaxLeft, height[left]);
                water += currMaxLeft - height[left];
                
            } else {
                right -= 1;
                currMaxRight = max(currMaxRight, height[right]);
                water  += currMaxRight - height[right];
            }
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
