class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        int i = 0;
        while (i < s.length()) {
            count[t.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
            i++;
        }

        int ans = 0;
        i = 0;

        while (i < 26) {
            ans += Math.max(0, count[i]);
            i++;
        }

        return ans;
    }
}