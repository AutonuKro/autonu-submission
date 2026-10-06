class Solution {
    public String minWindow(String s, String t) {

        int[] count = new int[128];

        // What we need
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int remaining = t.length();

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            // If count[c] > 0, this character was still needed
            if (count[c] > 0) {
                remaining--;
            }

            count[c]--;

            // Window is valid
            while (remaining == 0) {

                // Update answer
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                char left = s.charAt(l);

                count[left]++;

                // We removed a required character
                if (count[left] > 0) {
                    remaining++;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLen);
    }
}