class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
         for(Character ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1);
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