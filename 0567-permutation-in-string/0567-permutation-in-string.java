class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] freq = new int[26]; 
        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        int[] aux = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            aux[s2.charAt(i) - 'a']++;
        }
        
        int i = s1.length();
        while (i < s2.length()) {
            if (arraysEqual(aux, freq)) {
                return true;
            }
            aux[s2.charAt(i - s1.length()) - 'a']--;
            aux[s2.charAt(i) - 'a']++; 
            i++;
        }
        return arraysEqual(aux, freq);
    }

    private boolean arraysEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}