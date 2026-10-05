class Solution {
    public int characterReplacement(String s, int k) {
        // A B A A
        // l
        // r
        int map[] = new int[26];
        int maxFreq = 0;
        int res = 0;
        for(int l = 0, r = 0; r < s.length(); r++) {
            map[s.charAt(r) - 'A'] += 1;
            maxFreq = maxFreq(map);
            int lenOfSubstr = r - l + 1;
            if(lenOfSubstr - maxFreq <= k) {
                res = Math.max(lenOfSubstr, res);
            } else {
                map[s.charAt(l) - 'A'] -= 1;
                l += 1;
            }
        }
        return res;   
    }

    static int maxFreq(int map[]) {
        int max = 0;
        for(int i = 0; i < 26; i++) {
            max = Math.max(max, map[i]);
        }
        return max;
    }
}
