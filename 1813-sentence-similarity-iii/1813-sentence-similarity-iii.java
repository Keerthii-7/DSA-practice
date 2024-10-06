class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2=sentence2.split(" ");
        String[] smaller = words1.length <= words2.length ? words1 : words2;
        String[] larger = words1.length > words2.length ? words1 : words2;
        
        int i = 0;  // Pointer for matching from the start (prefix)
        int j = 0;  // Pointer for matching from the end (suffix)
        int m = smaller.length;
        int n = larger.length;
        
        // Match prefix
        while (i < m && smaller[i].equals(larger[i])) {
            i++;
        }
        
        // Match suffix
        while (j < m - i && smaller[m - 1 - j].equals(larger[n - 1 - j])) {
            j++;
        }
        
        // Check if the entire smaller sentence was matched as prefix or suffix
        return i + j == m;
    }
}