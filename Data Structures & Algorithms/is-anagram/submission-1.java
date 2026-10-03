class Solution {
    public boolean isAnagram(String s, String t) {
        //Use index of
        // s = racecar, t = carrace
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        Map<Character,Integer> seen = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = 0;
            if(seen.containsKey(c)) {
                int from = seen.get(c);
                idx = t.indexOf(c, from + 1);
            } else {
                idx = t.indexOf(c);
            }
            seen.put(c,idx);
            if(idx < 0) {
                return false;
            }
        }
        return true;
    }
}
