class Solution {
    public int longestConsecutive(int[] nums) {
        // check every number if it start of the sequence
        // once found count the number of consecutive number
        // Time complexity = O(N);
        // Space complexity = O(N);
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int maxSeq = 0;
        for(Integer num : numSet){
            if(numSet.contains(num - 1)) continue; // this means there is number that is smaller then the current num;
            else {
                //current num is start of sequence;
                //find all the consecutive nums;
                int curr = num;
                int currSeq = 1;
                while(numSet.contains(curr + 1)) {
                    currSeq += 1;
                    curr += 1;
                }
                maxSeq = maxSeq > currSeq ? maxSeq : currSeq;
            }
        }
        return maxSeq;
    }
}
