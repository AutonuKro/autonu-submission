class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        // p w w w k e w
        //     l
        //       r
        //space : O(1)
        //time : O(N*N), N = s.length();
        int max = 0;
        for(;right < s.length(); right++){
            char c = s.charAt(right);
            int currIndex = s.indexOf(c, left);
            if (currIndex != right) {
                left = currIndex + 1;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
