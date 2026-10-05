class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //check for anagram;
        if(s1.length() > s2.length()) return false;
        int anagram[] = new int [26];
        for(int i = 0; i < s1.length(); i++) {
            anagram[s1.charAt(i) - 'a'] += 1;
        }
        String key = Arrays.toString(anagram);
        System.out.println(key);
        for(int l = 0, r = s1.length() - 1; r < s2.length(); r++, l++) {
            int j = l;
            anagram = new int[26];
            while(j <= r) {
                anagram[s2.charAt(j) - 'a'] += 1;
                j += 1;
            }
            System.out.println(Arrays.toString(anagram));
            if(key.equals(Arrays.toString(anagram))) return true;
        }
        return false;
    }

}
