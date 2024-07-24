class Pair{
    int v1,v2;
    Pair(int v1,int v2){
        this.v1=v1;
        this.v2=v2;
    }
}
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(i,mapping[i]);
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int val=0;
            int pow=0;
            if (num == 0) {
                val = map.get(0);
            } else {
                while(num!=0){
                    val=val+(int)(map.get(num%10)*Math.pow(10,pow));
                    pow++;
                    num=num/10;
                }
            }
            ans[i]=val;
        }
        Pair[] p=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            p[i]=new Pair(nums[i],ans[i]);
        }
        Arrays.sort(p,(e1,e2)->(e1.v2-e2.v2));
        ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=p[i].v1;
        }
        return ans;
    }
}