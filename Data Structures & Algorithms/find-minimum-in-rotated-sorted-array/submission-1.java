class Solution {
    public int findMin(int[] nums) {
        int h = nums.length - 1, l = 0;
        int min = nums[0];
        while(l <= h) {
            int mid = (h-l)/2 + l;
            if(nums[l] >= nums[h]) {
                if(nums[mid] <= nums[h]){
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                h = mid - 1;
            }
            min = Math.min(min, nums[mid]);
        }
        return min;
    }
}
