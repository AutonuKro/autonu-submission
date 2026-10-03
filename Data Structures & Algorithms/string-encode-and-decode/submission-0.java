class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int len = str.length();
            sb.append(len);
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int len = 0, idx = 0, n = 0;
        while(idx < str.length()){
            if(Character.isDigit(str.charAt(idx))) {
                idx++;
            } else if(str.charAt(idx) == '#') {
                // "5#Hello5#World"
                //.  idx
                len = Integer.valueOf(str.substring(n, idx));
                String sub = str.substring(idx + 1, idx + 1 + len);
                ans.add(sub);
                idx = idx+1+len;
                n = idx;
            }
        }
        return ans;
    }
}
