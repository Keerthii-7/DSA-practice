class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int count=0;
        int ans=0;
        Set<Integer> s=new HashSet<>();
        for(int item:nums){
            s.add(item);
        }
        for(int item:nums){
            if(!s.contains(item-1)){
                count=1;
                int k=item;
                while(s.contains(k+1)){
                    count++;
                    k=k+1;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}