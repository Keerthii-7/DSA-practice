class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        TreeMap<Integer,Integer> map1=new TreeMap<>((e1,e2)->{
            int freq=map.get(e1).compareTo(map.get(e2));
            if(freq==0){
                return e2-e1;
            }
            return freq;
            });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            map1.put(entry.getKey(),entry.getValue());
        }
        int[] ans=new int[nums.length];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:map1.entrySet()){
            int val=entry.getValue();
            while(val!=0){
                ans[i++]=entry.getKey();
                val--;
            }
        }
        return ans;
    }
}