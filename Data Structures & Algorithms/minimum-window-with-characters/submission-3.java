class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int formed = 0;
        int required = need.size();

        int l = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            // Add c to window
            if (need.containsKey(c)) {

                window.put(c, window.getOrDefault(c, 0) + 1);

                // Requirement for c just became satisfied
                if (window.get(c).equals(need.get(c))) {
                    formed++;
                }
            }

            // Try shrinking
            while (formed == required) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                char left = s.charAt(l);

                if (need.containsKey(left)) {

                    window.put(left, window.get(left) - 1);

                    // Requirement is no longer satisfied
                    if (window.get(left) < need.get(left)) {
                        formed--;
                    }
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}