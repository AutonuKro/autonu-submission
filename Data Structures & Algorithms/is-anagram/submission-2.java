class Solution {
    public boolean isAnagram(String s, String t) {
        //Use an array for all english small letters.
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;
        int chars[] = new int [26];
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            chars[idx] += 1;
            idx = t.charAt(i) - 'a';
            chars[idx] -= 1;
        }
        for(int i = 0; i < 26; i++) {
            if(chars[i] != 0) return false;
        }
        return true;
    }
}
