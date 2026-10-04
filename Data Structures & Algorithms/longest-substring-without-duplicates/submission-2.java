class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = i + 1;
            Set<Character> set = new HashSet<>();
            set.add(c);
            while(j < s.length()) {
                if(set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                j += 1;
            }
            max = max < set.size() ? set.size() : max;
        }
        return max;
    }
}
