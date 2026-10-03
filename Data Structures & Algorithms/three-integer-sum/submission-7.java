class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //nums = [-1,0,1,2,-1,-4]
        // nums = [-4,-1, -1, 0, 1, 2]
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if(sum > 0) r -= 1;
                else if (sum < 0) l += 1;
                else {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    l += 1;
                    // This it to avoid duplicate.
                    while (nums[l] == nums[l-1] && l < r) l += 1;
                }
            }
        }
        return ans;
    }
}
