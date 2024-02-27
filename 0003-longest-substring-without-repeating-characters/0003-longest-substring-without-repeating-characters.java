class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        int maxLen=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                ans=Math.max(ans,1+map.get(ch));        
            }
            map.put(ch,i);
             maxLen=Math.max(maxLen,i-ans+1);
        }
        return maxLen;
    }
}