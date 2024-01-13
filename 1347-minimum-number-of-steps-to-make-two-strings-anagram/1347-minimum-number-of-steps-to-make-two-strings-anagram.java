class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char ch1=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            map.put(ch1,map.getOrDefault(ch1,0)-1);
        }
        int ans=0;
         for(Character ch:map.keySet()){
             if(map.get(ch)>0){
                ans+=map.get(ch);
             }
        }
        return ans;
    }
}