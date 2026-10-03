class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int s = i > map.get(target - nums[i]) ? map.get(target - nums[i]) : i;
                int b = i < map.get(target - nums[i]) ? map.get(target - nums[i]) : i;
                return new int [] {s,b};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
