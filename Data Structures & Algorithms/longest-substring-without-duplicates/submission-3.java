class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding window
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0;
        //pwwwkew
        //   l
        //   r
        int max = 0;
        for(;right < s.length(); right++){
            char c = s.charAt(right);
            while(seen.contains(c)) {
                seen.remove(s.charAt(left));
                left += 1;
            }
            seen.add(c);
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}
