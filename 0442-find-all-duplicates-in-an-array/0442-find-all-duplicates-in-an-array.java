class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        sortFun(nums);
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    public void sortFun(int[] nums){
        int n=nums.length;
        int i=0;
       while(i<n){
            int val=nums[i];
            if(nums[val-1]!=val){
                swap(nums,i,val-1);
            }else{
                i++;
            }
        }
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}