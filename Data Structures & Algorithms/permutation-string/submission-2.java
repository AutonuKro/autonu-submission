class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int anagram[] = new int [26];
        for(int i = 0; i < s1.length(); i++) {
            anagram[s1.charAt(i) - 'a'] += 1;
        }
        String key = Arrays.toString(anagram);
        anagram = new int[26];
        for(int l = 0, r = 0; r < s2.length(); r++) {
            anagram[s2.charAt(r) - 'a'] += 1;
            if(key.equals(Arrays.toString(anagram))) return true;
            if (r - l + 1 >= s1.length()) {
                anagram[s2.charAt(l) - 'a'] -= 1;
                l += 1;
            }
        }
        return false;
    }
}
