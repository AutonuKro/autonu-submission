class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int chars [] = new int[26];
            for(int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'a';
                chars[idx] += 1;
            }
            List<String> t = ans.getOrDefault(Arrays.toString(chars), new ArrayList<>());
            t.add(str);
            ans.put(Arrays.toString(chars), t);
        }
        List<List<String>> finalAns = new ArrayList<>();
        for(List<String> value : ans.values()) {
            finalAns.add(value);
        }
        return finalAns;
    }
}
