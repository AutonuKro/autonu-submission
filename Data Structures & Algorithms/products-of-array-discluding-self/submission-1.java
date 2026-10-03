class Solution {
    public int[] productExceptSelf(int[] nums) {
        //brute force;
        // int [] ans = new int[nums.length];
        // for(int i = 0; i < nums.length; i++) {
        //     int prod = 1;
        //     for (int j = 0; j < nums.length; j++) {
        //         if(nums[i] != nums[j]) {
        //             prod *= nums[j];
        //         } 
        //     }
        //     ans[i] = prod;
        // }
        // return ans;
        //better approach
        int n = nums.length;
        int ans[] = new int[n], prefix[] = new int[n], suffix[]= new int[n];
        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i-1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int i = 0; i < n; i++) {
            prefix[i] *= suffix[i];
        }
        return prefix;
    }
}  
