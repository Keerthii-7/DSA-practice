class Solution {
    public void nextPermutation(int[] nums) {
        int break_point=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                break_point=i-1;
                break;
            }
        }
        System.out.println(break_point);
        if(break_point==-1){
            reverse(nums,0,nums.length-1);
        }
        else{
            int min_right=findMin(nums,break_point+1,nums.length-1,break_point);
            swap(nums,break_point,min_right);
            reverse(nums,break_point+1,nums.length-1);
        }
    }
public void swap(int[] nums,int i,int j){
    int t=nums[i];
    nums[i]=nums[j];
    nums[j]=t;
}
public void reverse(int[] nums,int i,int j){
    int k=i;
    int l=j;
    while(k<=l){
        swap(nums,k,l);
        k++;
        l--;
    }
}
    public int findMin(int[] nums,int i,int j,int break_point){
        int min=i;
        for(int k=i+1;k<=j;k++){
            if(nums[k]<=nums[min] && nums[k]>nums[break_point]){
                min=k;
            }
        }
        return min;
    }
}